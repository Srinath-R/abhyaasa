package sri.misc;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        int limit = 100;
        IntStream.range(0,limit+1).forEach((i)->{
            boolean isFizz = i%3 == 0;
            boolean isBuzz = i%5 == 0;

            if(isFizz && isBuzz) {
                System.out.println("FizzBuzz");
                return;
            }
            if(isFizz) {
                System.out.println("Fizz");
                return;
            }
            if(isBuzz) {
                System.out.println("Buzz");
                return;
            }
            System.out.println(i);
        });
    }
}
