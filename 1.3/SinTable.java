public class SinTable{
public static void main(String[]args){
int i;
for (i=0;i<=90;i++){
String temp = String.format("sin(%d)=%f",i,Math.sin((double)i/180.0*Math.PI));
System.out.println(temp);
}
}
}