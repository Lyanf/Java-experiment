import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionExample{
    public static void main(String[]args) throws Exception{
        URL url = new URL(args[0]);
        URLConnection con = url.openConnection();
        System.out.println("URL used is : "+con.getURL().toExternalForm());
        System.out.println("Content Type: "+con.getContentType());
        System.out.println("Content Length: "+con.getContentLength());
        System.out.println("Last Modified: "+new Date(con.getLastModified()));
        System.out.println("First Three lines :");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        for (int i = 0;i<10;i++){
            String line = in .readLine();
            if (line == null){
                break;
            }
            System.out.println(" "+line);
        }

    }
}