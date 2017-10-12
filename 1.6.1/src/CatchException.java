public class CatchException {
    public static void main(String[]args){
        int[] myarr=new int[10];
        try{
            myarr[10]=10;

            //这一句话并不会执行,说明在try里面抛出了异常,那么就直接终止这个后面的执行,到catch里面
            System.out.println("test");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界异常");
        }

        //无论如何都会执行finally
//        finally {
//            System.out.println("test b");
//        }

        //如果异常处理得当,那么程序能够继续往下进行
        //System.out.println("test c");
    }
}
