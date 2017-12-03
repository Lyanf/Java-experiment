import javax.swing.*;

class Hello extends JFrame {
    public Hello() {
        JLabel jLabel = new JLabel("姓名");
        JTextField jTextField = new JTextField(20);
        JButton ok = new JButton("确定");
        JButton clear = new JButton("清除");
        JPanel jPanel = new JPanel();
        jPanel.add(jLabel);
        jPanel.add(jTextField);

        jPanel.add(ok);
        jPanel.add(clear);
        add(jPanel);
        setVisible(true);
        setSize(500, 300);
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
    }
}