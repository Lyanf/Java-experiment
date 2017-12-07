import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.StrictMath.sin;

class MyCanvas extends Canvas {
    private int flag = 0;
    MyCanvas(){flag = 0;}
    public int getFlag(){
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        repaint();
    }
    public void paint(Graphics g){
        int i;
        if (flag ==1 ){
            g.drawLine(0,250,600,250);
            g.drawLine(0,0,0,500);
            g.drawLine(0,0,600,0);
            for (i=0;i<3600;i++){
                g.drawOval((int)(i/10.0),(int)(250-250*Math.sin(i/10.0/180.0*Math.PI)),1,1);
            }
        }
        else if(flag==2) {
            g.drawLine(0,0,600,0);
            g.drawLine(0,250,600,250);
            g.drawLine(0,0,0,500);

            for (i= 0; i<3600;i++){
//                g.drawOval((int)(i*3.14/180.0/10),(int)(250+250*Math.cos((double)i/10*3.14/180.0)),1,1);
                g.drawOval((int)(i/10.0),(int)(250-250*Math.cos(i/10.0/180.0*Math.PI)),1,1);

            }
        }

    }
}

class MyFrame extends JFrame{
    private int flag;
    private MyCanvas myCanvas;
    public MyFrame(){
        Button bt1 = new Button("sin");
        Button bt2 = new Button("cos");
        Button bt3 = new Button("exit");
        bt1.setPreferredSize(new Dimension(150,50));
        bt2.setPreferredSize(new Dimension(150,50));
        bt3.setPreferredSize(new Dimension(150,50));
        bt1.addActionListener(new btn1Listener());
        bt2.addActionListener(new btn2Listener());
        bt3.addActionListener(new btn3Listener());
        setSize(800,700);
        setLayout(new BorderLayout());
        Panel panel = new Panel();
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.setSize(600,50);
        add(panel,BorderLayout.NORTH);
        Panel panel1 = new Panel();
        panel1.setSize(700,600);
        myCanvas = new MyCanvas();
        panel.add(myCanvas);
        myCanvas.setSize(600,500);
        add(panel,BorderLayout.CENTER);
    }
    private class btn1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            myCanvas.setFlag(1);
            myCanvas.repaint();
        }
    }
    private class btn2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            myCanvas.setFlag(2);
            myCanvas.repaint();
        }
    }
    private class btn3Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}
class test{
    static public void main(String[]args){
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
    }
}