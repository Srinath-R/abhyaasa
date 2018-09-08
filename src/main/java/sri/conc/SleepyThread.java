package sri.conc;

public class SleepyThread {
    public static void main(String[] args) throws InterruptedException {
        String[] str = {"Nimajji","idella","beka","ninge!!"};

        for (String s : str) {
            Thread.sleep(4000);
            System.out.println(s);
        }
    }
}
