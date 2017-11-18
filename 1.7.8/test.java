import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.*;

public class test {
    public static void main(String[]args){
        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write("39.56  3242.34  3434.34");
            writer.close();
            FileReader reader =  new FileReader("test.txt");
            BufferedReader bufferedReader =new BufferedReader(reader);
            while (true){
                String temp = bufferedReader.readLine();
                if (temp==null)break;
                String[] a ;
                a= temp.split("s");
                System.out.println(a[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
