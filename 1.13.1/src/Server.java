import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4001);
        Socket soc = ss.accept();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(soc.getInputStream())
        );
        String message = "";
        String temp;
        do {
            temp = br.readLine();
            if (temp == null) {
                break;
            }
            System.out.println("收到信息" + temp);
            message = message + temp + "\n";
        }
        while (true);
        br.close();
        PrintStream ps = new PrintStream(new FileOutputStream("message.txt"));
        ps.println(message);
        ps.close();
        br.close();
        soc.close();
        System.out.println("已经存储消息，请打开文件检查");
    }
}