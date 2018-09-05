package sri.conc;


import java.util.Random;

import static sri.conc.Producer.EOM;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String msg = buffer.read(); !EOM.equals(msg); msg = buffer.read()) {
            System.out.format("Message received: %s %n",msg);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
