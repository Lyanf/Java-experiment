import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControl extends JFrame implements ActionListener {
    JButton btnDisplay;
    JLabel lblMsg;
    public ButtonControl(){
        super("按钮控件演示程序");
        btnDisplay = new JButton("显示消息");
        lblMsg = new JLabel("");
        add(btnDisplay,BorderLayout.NORTH);
        add(lblMsg);
        btnDisplay.addActionListener(this);
        setSize(200,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("显示消息")) {
//            btnDisplay.setLabel("隐藏消息");
            btnDisplay.setText("隐藏消息");
            lblMsg.setText("你好，世界！");
        } else if (ae.getActionCommand().equals("隐藏消息")) {
//            btnDisplay.setLabel("显示消息");
            btnDisplay.setText("显示消息");
            lblMsg.setText("");
        }
    }
    public static void main(String[]args){
        new ButtonControl();
    }
}
