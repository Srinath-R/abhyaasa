package sri.conc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter implements Runnable {
    private final Stream<String> lines;
    private transient final Map<String, Integer> countMap;

    public WordCounter(Stream<String> stream, Map<String, Integer> countMap) {
        this.lines = stream;
        this.countMap = countMap;
    }

    public void countWords() {
        Map<String, Integer> counts = lines.flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word->word.replaceAll("[^a-zA-Z]","").toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        countMap.putAll(counts);
    }

    @Override
    public void run() {
        System.out.println("Called from "+Thread.currentThread().getName());
        countWords();
    }

    public static void main(String[] args) {
        Path filePath = Paths.get("src\\main\\resources\\input.txt");
        try {
            final Stream<String> lines = Files.lines(filePath);
            Map<String,Integer> countMap = new ConcurrentHashMap<>();
            WordCounter wordCounter = new WordCounter(lines,countMap);
            wordCounter.countWords();
            countMap.forEach((key, value) -> System.out.format("%s->%d%n", key, value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}