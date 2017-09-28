
public class MyComplex{
    public static void main(String[]arge){
        MyComplex m1=new MyComplex(3.4,8.0);
        MyComplex m2=new MyComplex(3.4,8.0);
        System.out.println(m1);
        System.out.println("m1 = "+m1);
        System.out.println("m2 = "+m2);
        System.out.println("m1==m2="+(m1==m2));
        System.out.println("m1.equals(m2)="+m1.equals(m2));
        MyComplex m3=new MyComplex(4.4,-8.9);
        System.out.println("m3="+m3);
        MyComplex m4=MyComplex.add(m1,m3);
        MyComplex m5=MyComplex.sub(m2,m3);
        MyComplex m6=MyComplex.mul(m1,m2);
        MyComplex m7= MyComplex.div(m1,m2);
        System.out.println("m1+m3="+m4);
        System.out.println("m2-m3="+m5);
        System.out.println("m1*m2="+m6);
        System.out.println("m1/m2="+m7);
    }
    private double a,b;
    MyComplex(double i_a,double i_b){
        a=i_a;
        b=i_b;
    }
    static public MyComplex add(MyComplex x,MyComplex y){
        return new MyComplex(x.a+y.a,x.b+y.b);
    }
    static public MyComplex sub(MyComplex x,MyComplex y){
        return new MyComplex(x.a-y.a,x.b-y.b);
    }
    static public MyComplex mul(MyComplex x,MyComplex y){
        return new MyComplex(x.a*y.a-x.b*y.b,x.a*y.b+x.b*y.a);
    }
    static public MyComplex div(MyComplex x,MyComplex y){
        double a=x.a,b=x.b,c=y.a,d=y.b;
        return new MyComplex((a*c+b*d)/(c*c+d*d),(b*c-a*d)/(c*c+d*d));
    }

    @Override
    public String toString(){
        final MyComplex obj=(MyComplex) this;
        return String.format("%f+(%fi)",obj.a,obj.b);
    }

    @Override
    public boolean equals(Object i_y){
        final MyComplex x=(MyComplex) this;
        final MyComplex y=(MyComplex) i_y;
        if (null==y){
            return false;
        }
        if (x.a==y.a&&x.b==y.b){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (int)(this.a*10+this.b);
    }

}