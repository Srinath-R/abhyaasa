package sri.conc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCountExecutor {
    public static void main(String[] args) {
        final Map<String,Integer> countMap = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        final Path filePath1 = Paths.get("src\\main\\resources\\input.txt");
        final Path filePath2 = Paths.get("src\\main\\resources\\input2.txt");
        final Path filePath3 = Paths.get("src\\main\\resources\\input3.txt");

        try {
            executor.submit(new WordCounter(Files.lines(filePath1), countMap)).get();
            executor.submit(new WordCounter(Files.lines(filePath2), countMap)).get();
            executor.submit(new WordCounter(Files.lines(filePath3),countMap)).get();
            executor.shutdown();
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            if(!executor.isShutdown())
                executor.shutdown();
        }
        countMap.forEach((key, value) -> System.out.format("%s -> %d%n", key, value));

    }
}
