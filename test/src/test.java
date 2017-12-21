import javax.swing.*;

public class test extends JFrame{
    public static void main(String args[]){
        ImageIcon imageIcon = new ImageIcon("1.jpg");
        JPanel jPanel = new JPanel();
        JLabel jLabel=new JLabel("",imageIcon,JLabel.CENTER);
        jPanel.add(jLabel);
        JFrame jFrame =new test();
        jFrame.add(jPanel);
        jFrame.setSize(500,500);
        jFrame.setVisible(true);

    }
}
