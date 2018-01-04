import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class minibroswer extends JFrame implements ActionListener, Runnable {
    JButton button;
    URL url;
    JTextField text;
    JEditorPane editPane;
    byte b[] = new byte[128];
    Thread thread;

    public minibroswer() {
        text = new JTextField(20);
        editPane = new JEditorPane();
        editPane.setEditable(false);
        button = new JButton("确定");
        button.addActionListener(this);
        thread = new Thread(this);
        JPanel p = new JPanel();
        p.add(new JLabel("输入网址:"));
        p.add(text);
        p.add(button);
        Container con = getContentPane();
        con.add(new JScrollPane(editPane), BorderLayout.CENTER);
        con.add(p, BorderLayout.NORTH);
        setBounds(60, 60, 560, 460);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        editPane.setPage(e.getURL());
                    } catch (IOException e1) {
                        editPane.setText("" + e1);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(thread.isAlive())){
            thread = new Thread(this);67
        }
        try{
            thread.start();
        }
        catch (Exception e1){
            text.setText("我正在读取"+url);
        }
    }
    @Override
    public void run(){
        try{
            int n = -1;
            editPane.setText(null);
            editPane.setContentType("text/html");
            url = new URL(text.getText().trim());
            editPane.setPage(url);
        }
        catch (MalformedURLException e1){
            text.setText(""+e1);
        }
        catch (IOException e2){
            text.setText(""+e2);
        }
    }
    public static void main(String[]args){
        new minibroswer();
    }
}
