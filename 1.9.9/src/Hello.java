import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Hello extends JFrame {
    private JTextField jTextField;
    public Hello() {
        JLabel jLabel = new JLabel("姓名: ");
        jTextField = new JTextField(35);
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        jPanel.add(jLabel);
//        jPanel.add(jTextField);

        JButton ok = new JButton("确定");
        JButton clear = new JButton("清除");
        ok.addActionListener(new okListener());
        clear.addActionListener(new clearListener());
        JPanel jPanel1 = new JPanel();
//        jPanel1.add(ok);
//        jPanel1.add(clear);
//        jPanel.setSize(new Dimension(500,150));
//        jPanel1.setSize(new Dimension(500,150));
//        setLayout(new GridLayout(2,1));
//        add(jPanel);
//        add(jPanel1);
        this.setLayout(new FlowLayout());
        add(jLabel);
        add(jTextField);
        add(ok);
        add(clear);
        setVisible(true);
        setSize(500, 130);
    }
    private class okListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String getStr = jTextField.getText();
            String out = String.format("你好，%s，欢迎使用java编程！",getStr);
            jTextField.setText(out);
        }
    }
    private class clearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField.setText("");
        }
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
    }
}