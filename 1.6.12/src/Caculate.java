import java.util.Scanner;
public class Caculate {
    public static void main(String[]args){
        int x=1,y=1;
        char p='+';
        int out=0;
        try{
            x=Integer.parseInt(args[0]);
            y=Integer.parseInt(args[2]);
            p=args[1].charAt(0);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("输入参数个数错误");
            System.exit(1);
        }
        catch (NumberFormatException e ){
            System.out.println("你输入了非法字符");
            System.exit(1);
        }
        switch (p){
            case '+':
                out = x+y;
                break;
            case '-':
                out = x-y;
                break;
            case '*':
                out = x*y;
                break;
            case '/':
                try{
                    out = x/y;
                }
                catch (ArithmeticException e ){
                    System.out.println("除数不能为0,请重新输入");
                    Scanner scanner = new Scanner(System.in);
                    y = scanner.nextInt();
                    out = x/y;
                }
                finally {
                    break;
                }
            default:
                System.out.println("输入符号错误");
                break;
        }
        System.out.println("结果为:"+out);
    }
}
