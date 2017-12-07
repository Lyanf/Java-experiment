import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
class WindowCloser extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

public class CaculaterGUI extends Frame {
    private Panel panel;
    private Label label;
    private String[]names = {"7","8","9","+","4","5",
    "6","-","1","2","3","*","0",".","=","/"};
    private Button[] buttons = new Button[16];
    public CaculaterGUI(String title){
        super(title);
        label = new Label();
        panel = new Panel();
        panel.setLayout(new GridLayout(4,4));
        //这是一个空的label，那么就是默认的一个空字符串，以及相左对齐
        add(label,BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new Button(names[i]);
            panel.add(buttons[i]);
        }
        pack();//让frame能够适应他的子组件的大小
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    public static void main(String[]args){
        new CaculaterGUI("caculater");
    }
}
