import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public void copy(String from,String to){
        try (FileReader reader = new FileReader(from)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            try (FileWriter writer = new FileWriter(to)) {
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                int i = 1;
                for (i = 1; ; i++) {
                    String temp = bufferedReader.readLine();
                    if (temp == null) {
                        //读完了
                        break;
                    } else {
                        String out = Integer.toString(i) + ":        " + temp+'\n';
                        bufferedWriter.write(out);
                    }
                }
                bufferedWriter.flush();
                bufferedReader.close();
                bufferedWriter.close();
                reader.close();
                writer.close();
            }
        }
        catch (IOException e ){
            System.out.println("程序错误");
            return;
        }
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String from = scanner.nextLine();
        String to = scanner.nextLine();
        CopyFile obj = new CopyFile();
        obj.copy(from,to);
//        try {
//            try (FileReader reader = new FileReader("test.txt")) {
////                try {
//
//                    BufferedReader bf = new BufferedReader(reader);
//                    while (true){
//                        String temp = bf.readLine();
//                        if (temp==null)break;
//                        System.out.println(temp);
//                    }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
