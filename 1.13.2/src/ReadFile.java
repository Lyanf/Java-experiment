import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class ReadFile extends JApplet implements ActionListener,Runnable{
    File file;
    JComboBox choice;
    JTextArea text;
    Thread thread;
    String item = null;
    JButton button;
    URL url;
    public void init(){
        choice = new JComboBox();
        thread = new Thread(this);
        int N = Integer.parseInt(getParameter("总数"));
        for (int i = 1;i<= N;i++) {
            choice.addItem(getParameter(String.valueOf(i)));
        }
        button = new JButton("开始读取");
        text = new JTextArea(12, 20);
        setLayout(new FlowLayout());
        button.addActionListener(this);
        add(choice);
        add(button);
        add(text);
    }
    public void actionPerformed(ActionEvent e ){
        text.setText(null);
        item = "" +choice.getSelectedItem();
        item = item.trim();
        if (!(thread.isAlive())) {
            thread = new Thread(this);
        }
        try{
            thread.start();
        }
        catch (Exception e ){

        }
    }
    public void run(){
        try{
            url = new URL(getCodeBase(),item);
            InputStream in = url.openStream();
            int n = -1;
            byte b[] = new byte[100];
            while ((n = in.read(b)) != -1) {
                String str = new String(b,0,n);
                text.append(str);
            }
        }
        catch (Exception ee){}
    }
}
