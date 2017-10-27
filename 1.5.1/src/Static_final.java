public class Static_final {
    static int i =10;		//i=10
    static final  int k=20;
    static{i=i+5;}			//先进行,10---15
    public static void main(String[]args) {
        System.out.println("i=" + i);		//输出,i为7
        System.out.println("k=" + k); 		//输出,k为20
        //k = 30;			//这里如果不注释,就会错,因为是final

    }
    static {i=i/2;}			//15/2=7
}

