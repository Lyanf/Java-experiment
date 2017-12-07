import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class actiontest extends Frame {
    public actiontest(){
        super("测试事件");
        JButton b1 = new JButton("红色");
        JButton b2 = new JButton("蓝色");
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        MyListener myListenner = new MyListener();
        b1.addActionListener(myListenner);
        b2.addActionListener(myListenner);
        addWindowListener(new WindowDestory());
    }
    private class MyListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String str= e.getActionCommand();
            if (str.equals("红色")) setBackground(Color.red);
            else setBackground(Color.blue);
        }
    }
    public static void main(String[]args){
        actiontest myapp = new actiontest();
        myapp.setSize(300,300);
        myapp.setVisible(true);
    }
}

class WindowDestory extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}