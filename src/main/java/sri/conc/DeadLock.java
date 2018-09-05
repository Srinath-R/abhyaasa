package sri.conc;

public class DeadLock {
    static class Maga {
        private String name;
        //private static final Object LOCK = new Object();

        public Maga(String name) {
            this.name = name;
        }

        public synchronized void baggu(Maga maga) {
            System.out.format("%s: %s baggidane. %n",name,maga.getName());
            maga.matteBaggu(this);
        }

        public synchronized void matteBaggu(Maga maga) {
            System.out.format("%s: %s matte baggida. %n", name, maga.getName());
        }

        private String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Maga seenu = new Maga("Seenu");
        Maga subbu = new Maga("Subbu");

        new Thread(() -> seenu.baggu(subbu)).start();
        new Thread(() -> subbu.baggu(seenu)).start();
    }
}
