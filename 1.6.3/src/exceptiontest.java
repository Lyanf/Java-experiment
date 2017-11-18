class myexception extends Exception{
    String mymsg="我的异常信息";
    //经过查看源码,这个super调用的其实是Throwable类里面的构造函数,修改的里面一个属性
    myexception(){
        super("我自己定义的异常");
    }
    myexception(String msg){
        super(msg);
    }
    public void displayme(){
        System.out.println(mymsg);
    }
}

class exceptiontest{
    public static void main(String[] args){
        try{
            if (args[0].charAt(0)=='A'){
                myexception e=new myexception();
                throw e;
            }
            else {
                System.out.println(args[0]);
            }
        }
        catch(myexception aaaa){
            System.out.println(aaaa.getMessage());
            aaaa.displayme();
        }
    }

}