public class Reptitle extends Thread{
    public void run(){
        for (int a = 0;a<50;a++){
            System.out.println(currentThread().getName()+" : I am crawling "+a+" step!");
            try{
                sleep(100);
            }
            catch (InterruptedException e ){
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[]args){
        Reptitle reptitle = new Reptitle();
        reptitle.setName("Reptitle");
        Reptitle reptitle2 = new Reptitle();
        reptitle2.setName("Reptitle2");
        reptitle.start();
        reptitle2.start();
    }
}