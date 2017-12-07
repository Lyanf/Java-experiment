import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class WindowCloser extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e ){
        System.exit(0);
    }
}
class MyPanel extends Panel {
    String msg = "Pressed Key:";
    public MyPanel(){
        MyKeyAdapter bAction = new MyKeyAdapter();
        this.addKeyListener(bAction);
    }
    public void paint(Graphics g){
        g.setFont(new Font("宋体",Font.BOLD,24));
        g.drawString(msg,20,50);
    }
    private class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent kevent){
            int keycode = kevent.getKeyCode();
            msg = "Pressed Key: "+keycode+"char: "+(char)keycode;
            repaint();
        }
        @Override
        public void keyReleased (KeyEvent kevent){
            setBackground(Color.red);
            repaint();
        }
        @Override
        public void keyTyped(KeyEvent kevent){
            if (kevent.getKeyChar() =='x')System.exit(0);
        }
    }


}
public class keytest1{
    public static void main(String[]args){
        Frame myframe = new Frame("键盘测试");
        MyPanel myPanel = new MyPanel();
        myframe.add(myPanel);
        myframe.addWindowListener(new WindowCloser());
        myframe.setSize(300,300);
        myframe.setVisible(true);
    }
}