public class Program {
    String name="兰州大学信息学院";
    int no1=10;
    int no2=20;
    public Program(){
        try{
            System.out.println(name);
            System.out.println("相除结果为:"+no1/no2);
        }
        //算术错误
        catch(ArithmeticException e){
            System.out.println("不能除以0!");
        }
        finally {
            name=null;
            System.out.println("Finally已经执行!");
        }
    }

    public static void main(String[]args){
        new Program();
    }
}
