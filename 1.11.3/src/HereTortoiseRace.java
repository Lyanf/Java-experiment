class Tortoise extends Thread {
    int sleepTime = 0, targetLength = 100;

    public Tortoise(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Tortoise");
    }

    @Override
    public void run() {
        while (true) {
            targetLength--;
            System.out.println("T");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }

            if (targetLength <= 0) {
                System.out.println(getName() + "到达目的地！\n");
                stop();
            }
        }
    }
}

class Hare extends Thread {
    int sleepTime = 0, targetLength = 100;

    public Hare(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Hare");
    }

    @Override
    public void run() {
        while (true) {
            targetLength -= 3;
            System.out.println("*");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
            }

            if (targetLength <= 0) {
                System.out.println(getName() + "到达目的地！\n");
                stop();
            }
        }
    }
}

public class HereTortoiseRace {
    public static void main(String[] args) {
        Hare hare;
        hare = new Hare(500, 100);
        Tortoise tortoise;
        tortoise = new Tortoise(100, 100);
        hare.start();
        tortoise.start();
    }
}