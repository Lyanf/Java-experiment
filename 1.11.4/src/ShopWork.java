class ShopWorker extends Thread {
    static Thread zhangsan, lisi, boss;
    public void init (){
        zhangsan = new ShopWorker();
        lisi = new ShopWorker();
        boss = new ShopWorker();
        zhangsan.setName("张三");
        lisi.setName("李四");
        boss.setName("老板");
    }

    public void run() {
        int i = 0;
        if (Thread.currentThread() == zhangsan) {
            while (true) {
                try {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "继续工作");
                    if (i == 3) return;
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(boss.getName() + "让" + Thread.currentThread().getName() + "继续工作");
                }
            }
        } else if (Thread.currentThread() == lisi) {
            while (true) {
                try {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "已经搬了" + i + "箱货物，休息一会儿");
                    if (i == 3) return;
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(boss.getName() + "让" + Thread.currentThread().getName() + "继续工作");
                }
            }
        } else if (Thread.currentThread() == boss) {
            while (true) {
                zhangsan.interrupt();
                lisi.interrupt();
                if (!(zhangsan.isAlive() || lisi.isAlive())) {
                    System.out.println("下班了");
                    return;
                }
            }
        }
    }
}
class ShopWork{
    public static void main(String[]args){
        ShopWorker shop = new ShopWorker();
        shop.init();
        shop.zhangsan.start();
        shop.boss.start();
        shop.lisi.start();
    }
}