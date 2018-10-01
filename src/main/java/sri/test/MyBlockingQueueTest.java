package sri.test;

import sri.conc.MyBlockingQueue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MyBlockingQueueTest {
    private static final MyBlockingQueue<String> queue = new MyBlockingQueue<>(1000);

    public static void main(String[] args) {
        //consume first 100 words.
        new Thread(()->{
            System.out.format("%s: Started consuming.%n",Thread.currentThread());
            int count = 1;
            try {
                while (count <= 1000) {
                    String word = queue.dequeue();
                    System.out.format("%s: Got word %d => %s.%n", Thread.currentThread(), count++, word);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.format("%s: Started emitting.%n",Thread.currentThread());
            Path path = Paths.get("src\\main\\resources\\input.txt");
            try(Stream<String> lines = Files.lines(path)) {
                lines.flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .forEach(val -> {
                    try {
                        System.out.format("%s: Emitting word => %s.%n", Thread.currentThread(),val);
                        queue.enqueue(val);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void consume() {

    }

    private static void emit(Stream<String> words) {

    }
}
