import java.applet.*;
import java.awt.*;
public class CosApplet extends Applet{
public void paint(Graphics g){
int i;
for (i=30;i<=60;i++){
double n=Math.PI*i/180;
String x=String.format("cos(%d)=%f",i,Math.cos(n));
g.setFont(new Font("ËÎÌו",Font.BOLD,30));
g.drawString(x,100,23*i-580);
}
}
}