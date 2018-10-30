package sri.conc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeBow {
    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void bow(Friend bower) {

            if(checkLock(bower)) {
                try {
                    System.out.format("%s: %s has bowed to me.%n",name,bower.name);
                    bower.bowBack(this);
                }finally {
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: I'm already bowing to %s.%n",name,bower.name);
            }
        }

        private void bowBack(Friend friend) {
            System.out.format("%s: %s has bowed back to me!%n",name,friend.name);
        }

        private boolean checkLock(Friend bower) {
            boolean myLock = false;
            boolean bowerLock = false;
            try {
                myLock = lock.tryLock();
                bowerLock = bower.lock.tryLock();
            }finally {
                if(!(myLock && bowerLock)) {
                    if(myLock) {
                        lock.unlock();
                    }
                    if(bowerLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && bowerLock;
        }
    }

    static class BowRunner implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowRunner(Friend bower,Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bower.bow(bowee);
            }
        }
    }

    public static void main(String[] args) {
        final Friend seenu = new Friend("Seenu");
        final Friend subbu = new Friend("Subbu");
        new Thread(new BowRunner(seenu,subbu)).start();
        new Thread(new BowRunner(subbu,seenu)).start();
    }
}
