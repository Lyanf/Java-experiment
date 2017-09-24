class Shiyan4_2_2{
    public static void main(String[]args){
        int n =100;
        Sieve s=new Sieve();
        s.executeFilter(n);
        System.out.println("小于"+n+"素数有:");
        s.outFilter();
    }
}
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
    public void executeFilter(int n){
        Counter c=new Counter(2);
        for (;c.getValue()<n;c.next()){
            passFilter(c);
        }
    }
    public void passFilter(Counter c){
        for (int i = 0;i<filterCount/2;i++)
            //这个地方有疑问,这个素数的判断为什么会和之前已经判断成功的素数的个数有关,或者说为什么要除以二?
            if (c.getValue()%(i+2)==0&&c.getValue()!=(i+2))return;
        addElementIntoFilter(c.getValue());
    }
    private void addElementIntoFilter(int x){
        f[filterCount]=x;
        filterCount++;
    }
    public void outFilter(){
        for (int i =0;i<filterCount;i++){
            System.out.printf("%4d",f[i]);
            if ((i+1)%10==0)System.out.println();
        }
    }
}