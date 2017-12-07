import javax.print.attribute.standard.MediaPrintableArea;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MPanel extends Panel{
    int [] x,y;
    int count;
    public MPanel(){
        x=new int[50];
        y=new int[50];
        count=0;
        MyMouseAdapter mAction = new MyMouseAdapter();
        this.addMouseListener(mAction);
    }
    public void paint(Graphics g){
        for (int i = 1;i<=count;i++){
            g.fillOval(x[i],y[i],5,5);
        }
    }
    private class MyMouseAdapter extends MouseAdapter{
        public void mouseClicked(MouseEvent m){
            count++;
            x[count] = m.getX();
            y[count] = m.getY();
            repaint();
            System.out.println(this.getClass());
        }
    }
}
class WindowCloser extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
class mousetest1{
    public static void main(String[]args){
        Frame myframe = new Frame("鼠标测试");
        MPanel mp = new MPanel();
        myframe.add(mp);
        myframe.setSize(400,400);
        myframe.setVisible(true);
        myframe.addWindowListener(new WindowCloser());
    }
}