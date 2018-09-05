package sri.conc;

import java.time.Duration;
import java.time.Instant;

public class SimpleThreads {
    static void printThreadMessage(String message) {
        System.out.format("%s : %s%n",Thread.currentThread().getName(),message);
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {
            String[] info = {"ondu","eradu","mooru","nalku"};
            try {
                for(String s : info) {
                    Thread.sleep(4000);
                    printThreadMessage(s);
                }
            }catch (InterruptedException iex) {
                printThreadMessage("Innu agirlilla");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long patience = 1000*60*60L;

        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        printThreadMessage("Shuru..");
        Instant startedOn = Instant.now();
        Thread t = new Thread(new MessageLoop());
        t.start();
        while (t.isAlive()) {
            printThreadMessage("Innu kaaytaidini....");
            t.join(1000);
            if(Duration.between(startedOn,Instant.now()).toMillis() > patience
                && t.isAlive()) {
                printThreadMessage("idrakkan saakaytu... ");
                t.interrupt();
                t.join();
            }
        }
        printThreadMessage("abba konegu mugitu..");
    }
}
