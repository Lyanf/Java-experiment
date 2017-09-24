public class Fibonacci{
protected static int fib(int n){
if (1==n||0==n)
return 1;
else return fib(n-1)+fib(n-2);
}
public static void main(String[] argss){
int i;
for (i=0;i<20;i++)
	System.out.println(fib(i));
}}