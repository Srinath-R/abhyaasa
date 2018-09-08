package sri.conc;

import java.io.IOException;

public class HiRunnable {
    public static void main(String[] args) throws IOException {
        Thread t = new Thread(()->System.out.println("Hi from "+Thread.currentThread()));
        t.start();
    }
}
