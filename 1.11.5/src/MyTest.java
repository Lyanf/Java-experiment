import javax.swing.*;
import java.awt.*;


class MyPanel extends JPanel {
    private int x, y;
    private int i;
    private int picx, picy;
    private Image[] imageIcon;

    public void setI(int i) {
        this.i = i;
    }

    public MyPanel() {
        picx = picy = 100;
        imageIcon = new Image[4];
        for (i = 0; i < 4; i++) {
            String path = i + 1 + ".jpg";
            imageIcon[i] = new ImageIcon(path).getImage();
        }
        x = y = 0;
        this.setSize(500, 500);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 100, x + 100, 100);
        g.drawLine(100, 0, 100, y + 100);
        try {
            g.drawImage(imageIcon[this.i], picx, picy, 100, 100, null);
        } catch (Exception e) {
        }
    }

    public void changeLine() {
        x++;
        y++;
    }

    public void changePic() {
        picx++;
        picy++;
    }
}

public class MyTest extends JFrame {
    MyPanel myPanel;

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public MyTest() {
        MyPanel myPanel = new MyPanel();
        this.myPanel = myPanel;
        this.add(myPanel);
        this.setVisible(true);
        this.setSize(500, 500);
        MyPaintLine myPaint = new MyPaintLine();
        MyPaintPic myPaintPic = new MyPaintPic();
        Repaint repaint = new Repaint();
        myPaint.start();
        myPaintPic.start();
        repaint.start();
    }

    class MyPaintLine extends Thread {
        @Override
        public void run() {
            int i;
            for (i = 0; i < 500; i++) {
                try {
                    Thread.sleep(10);
                    myPanel.changeLine();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyPaintPic extends Thread {
        @Override
        public void run() {
            int i;
            for (i = 0; i < 500; i++) {
                try {
                    Thread.sleep(10);
                    myPanel.setI(i / 100);
                    myPanel.changePic();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Repaint extends Thread {
        @Override
        public void run() {
            int i;
            for (i = 0; i < 500; i++) {
                try {
                    sleep(10);
                    myPanel.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}