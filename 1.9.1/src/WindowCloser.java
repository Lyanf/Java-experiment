import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowCloser extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
class Framel{
    public static void main(String[]args){
        Frame myapp = new Frame("GUI 窗口标题");
        myapp.setSize(300,300);
        myapp.setVisible(true);
        myapp.addWindowListener(new WindowCloser());
    }
}

class NewFrame extends Frame{
    static final String title = "GUI窗口标题";
    public NewFrame(String s){
        super(s);
        setSize(200,200);
        setVisible(true);
        addWindowListener(new WindowCloser());
    }

    public NewFrame(){
        super(title);
    }

    public static void main(String[]args){
        NewFrame n = new NewFrame("基本gui编程");
    }

}