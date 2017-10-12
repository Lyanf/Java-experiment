import java.awt.*;
public class Point{
    private int x,y;
    private Color mycolor;
    public Point(){
        x=y=0;
        mycolor=new Color(2,3,255);
    }
    public Point(int i_x,int i_y){
        x=i_x;
        y=i_y;
        mycolor=new Color(2,3,255);

    }
    public Point(int i_x,int i_y,Color i_mycolor){
        x=i_x;
        y=i_y;
        mycolor=i_mycolor;
        mycolor=i_mycolor;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Color getColor(){
        return mycolor;
    }
    public void setX(int i_x){
        x=i_x;
    }
    public void setY(int i_y){
        y=i_y;
    }
    public void setColor(Color i_color){
        mycolor=i_color;
    }
    public double distance(Point another){
        return Math.sqrt((double)(x-another.getX())*(x-another.getX())+(y-another.getY())*(y-another.getY()));
    }
    public boolean equals(Point another){
        if (x==another.getX()&&y==another.getY()&&mycolor.equals(another.getColor()))
            return true;
        else return false;
    }
    public String toString(){
        return String.format("x:%d  y:%d  color%s",x,y,getColor().toString());
    }
    public static void main(String[] args){
        Point A=new Point();
        Point B=new Point(50,60);
        Point C =new Point(100,200,Color.red);
        System.out.println("B:("+B.getX()+","+B.getY()+")"+"color:"+B.getColor());
        A.setX(100);
        A.setY(200);
        A.setColor(Color.red);
        System.out.println("A==B?"+A.equals(B));
        System.out.println("A---B"+A.distance(B));

    }
}