import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowCloser extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
public class frametest {
    public static void main(String[]args){
        Frame myframe = new Frame("测试窗口");
        Panel p1 = new Panel();
        Panel p11 = new Panel();
        p1.setBackground(Color.RED);
        p1.setLayout(new BorderLayout());
        myframe.add(p1);
        JLabel lb1 = new JLabel("名称");
        TextField txt = new TextField();
        p11.add(lb1);
        p11.add(txt);
        p1.add(p11,BorderLayout.NORTH);
        final TextArea ta = new TextArea(5,20);
        Font myfont = new Font("TimesNewRome",Font.BOLD,24);
        ta.setFont(myfont);
        p1.add(ta,BorderLayout.CENTER);
        Panel p12 = new Panel();
        JButton btn = new JButton("确定");
        JButton btn2 = new JButton("取消");
        p12.add(btn);
        p12.add(btn2);
        p1.add(p12,BorderLayout.SOUTH);
        p1.add(new JButton("东"),BorderLayout.EAST);
        p1.add(new JButton("西"),BorderLayout.WEST);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("我已经按了确定按钮");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }
        });
        Panel p2 =new Panel();
        JCheckBox b1 = new JCheckBox("老虎");
        JCheckBox b2 = new JCheckBox("狮子");
        JCheckBox b3 = new JCheckBox("大象",true);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.setBackground(Color.blue);
        myframe.add("South",p2);

        JComboBox moviestars = new JComboBox();
        moviestars.addItem("安东尼奥 班的拉斯");
        moviestars.addItem("莱昂纳多 迪卡普里奥");
        moviestars.addItem("马拉多纳");
        moviestars.addItem("休格兰特");
        moviestars.addItem("茱莉亚罗伯茨");
        p2.add(moviestars);
        myframe.add(new JButton("myframe northe"),BorderLayout.NORTH);
        myframe.add(new JButton("myframe ease"),BorderLayout.EAST);
        myframe.add(new JButton("myframe west"),BorderLayout.WEST);
        myframe.setSize(360,450);
        myframe.setVisible(true);
        myframe.addWindowListener(new WindowCloser());
    }
}
