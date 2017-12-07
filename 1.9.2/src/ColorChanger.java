import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowCloser extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
public class ColorChanger extends Frame {
    private Color color = Color.RED;
    //点了多少次
    private int times;
    public ColorChanger(String title){
        super(title);
        Button button = new Button("change color");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = (color == Color.RED)?Color.GREEN:Color.RED;
                //repaint()会call paint()和update()两个方法，所以重写了这两个方法
                repaint();
            }
        });
        add(button,BorderLayout.NORTH);
        setSize(300,300);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    @Override
    public void update(Graphics g){
        super.update(g);
        System.out.println("call update "+(++times)+"times");
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(0,0,300,300);
//        g.fillOval(0,0,100,100);
    }

    public static void main(String[]args){
        new ColorChanger("hello");
    }

}
