import java.io.*;

public class FileConvert {
    //和两个参数的作用差不多?其实是起到了一个默认参数的作用
    public void readFile (String FileName) throws IOException {
        readFile(FileName, null);
    }
//    第二个参数的作用是指定读取的编码
    public void readFile(String fileName, String charsetName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        InputStreamReader reader;
        FileReader readertest =  new FileReader(fileName);
        char[] testarray = new char[1000];
        readertest.read(testarray);
        System.out.println(testarray);
//        //如果没有指定编码格式的话
//        if (charsetName == null) {
//            reader = new InputStreamReader(in);
//        } else {
//            //如果指定了编码格式的话
//            reader = new InputStreamReader(in, charsetName);
//        }
//        //做一个缓冲,用来提高速度
//        BufferedReader br = new BufferedReader(reader);
//        String data;
//        //这个String用来保存读取的一行字符
//        while ((data = br.readLine()) != null) {
//            System.out.println(data);
//        }
//        //根据java的规则,关闭最外层相当于关闭所有相关流
//        br.close();
    }

    //另外一个方法,从哪里来,他是什么编码,到哪里去,变成什么编码
    public void copyFile(String from, String charsetFrom, String to, String charsetTo) throws IOException {
        //因为InputStream是一个抽象父类,但是这样写...
        InputStream in = new FileInputStream(from);
        InputStreamReader reader;

        if (charsetFrom == null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in, charsetFrom);
        BufferedReader br = new BufferedReader(reader);
        OutputStream out = new FileOutputStream(to);
        OutputStreamWriter writer = new OutputStreamWriter(out, charsetTo);
        BufferedWriter bw = new BufferedWriter(writer);
        String data;
        while ((data = br.readLine()) != null) {
            bw.write(data + '\n');
        }
        br.close();
        bw.close();


    }
    public static void main(String []args)throws IOException{
        FileConvert myapp = new FileConvert();
        myapp.readFile("test.txt");
        myapp.copyFile("test.txt",null,"unicode.txt","Unicode");
        myapp.copyFile("test.txt",null,"utf8.txt","UTF-8");
        myapp.readFile("unicode.txt");
        myapp.readFile("utf8.txt","UTF-8");
//        FileReader test = new FileReader("utf8.txt");
//        char []in =new char[100];
//        test.read(in);
//        System.out.println(in);



    }

}
