import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[]args)throws Exception{
        Socket soc = new Socket("127.0.0.1", 4001);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入消息到服务器");
        String message = "";
        String temp;
        PrintStream ps  = new PrintStream(soc.getOutputStream());
        while (!((temp = br.readLine()).equals("quit"))) {
            ps.println(temp);
        }
        ps.close();
        soc.close();
    }
}
