package sri.conc;

import java.util.Random;

public class HiRunnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1: Hi from "+Thread.currentThread());
        });
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2: Hi from "+Thread.currentThread());
        });
        
        t.start();
        t2.start();

        t.join();
        t2.join();
    }
}
