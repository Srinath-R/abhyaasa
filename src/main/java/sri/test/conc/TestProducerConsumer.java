package sri.test.conc;

import sri.conc.Buffer;
import sri.conc.Consumer;
import sri.conc.Producer;

import java.util.Arrays;
import java.util.List;

public class TestProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        List<String> data = Arrays.asList("Ondu","Eradu","Mooru","Nalku");
        new Thread(new Producer(data,buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
