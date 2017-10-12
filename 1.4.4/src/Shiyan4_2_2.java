class Shiyan4_2_2{
    public static void main(String[]args){
        int n =100;
        Sieve s=new Sieve();
        s.executeFilter(n);
        System.out.println("小于"+n+"素数有:");
        s.outFilter();
    }
}

//初始化一个int,然后能不停地给出他的++
class Counter{
    private int value;
    Counter(int val){value=val;}
    public int getValue(){return value;}
    public void next(){value++;}
}

class Sieve{
    final int Max=100;
    private int filterCount=0;
    private int[]f;
    public Sieve(){f=new int[Max];filterCount=0;}
    //创建一个int数组[100]

    //整个素数的起动机
    public void executeFilter(int n){
        Counter c=new Counter(2);
        //这里其实就是搞了个循环计数器,从2开始,c.next让值++
        for (;c.getValue()<n;c.next()){
            passFilter(c);
        }
    }

    //判断传进来的数是不是素数,如果是,那么就加进去
    public void passFilter(Counter c){
        for (int i = 0;i<filterCount/2;i++)
            //这个地方有疑问,这个素数的判断为什么会和之前已经判断成功的素数的个数有关,或者说为什么要除以二?
            //如果不是素数,那么return,就不能add了.
            //但是除以0和1显然是不行的,所以得从2开始,但是如果是2自己的话,2是素数,所以要加上一个!=,排除掉2
            if (c.getValue()%(i+2)==0&&c.getValue()!=(i+2))return;
        addElementIntoFilter(c.getValue());
    }

    //把一个数加进来,那么这个数组的作用就明显了,就是放素数的
    private void addElementIntoFilter(int x){
        f[filterCount]=x;
        filterCount++;
    }


    //把那个素数数组给输出,并且10个就打个回车
    public void outFilter(){
        for (int i =0;i<filterCount;i++){
            System.out.printf("%4d",f[i]);
            if ((i+1)%10==0)System.out.println();
        }
    }
}