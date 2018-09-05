package sri.conc;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private final List<String> src;
    private final Buffer buffer;
    public static final String EOM = "<EOM>";

    public Producer(List<String> data,Buffer buffer) {
        this.src = data;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        src.forEach((s) -> {
            buffer.write(s);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        buffer.write(EOM);
    }
}
