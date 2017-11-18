import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

public class FileLockTest{
    public static  void main(String[]args)throws IOException{
        File file = new File("out.tst");
        FileOutputStream fos = new FileOutputStream(file,true);
        FileChannel fc = fos.getChannel();
        FileLock flock = fc.tryLock();
        if (flock.isValid()){
            System.out.println(file.getName()+" is locked");
        }
        Scanner myin = new Scanner(System.in);
        String msg = myin.nextLine();
        fos.write((msg.getBytes()));
        flock.release();
        System.out.println(file.getName()+" is released");
        fc.close();
        fos.close();
    }
}