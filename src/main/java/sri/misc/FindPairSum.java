package sri.misc;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindPairSum {
    public static long productSum(int[] input) {
        int[] positives = IntStream.of(input).filter(i-> i>=0).toArray();
        int[] negatives = IntStream.of(input).filter(i-> i<0).toArray();
        long sum = 0;
        Arrays.sort(positives);
        Arrays.sort(negatives);
        if(positives.length%2 == 0) {
            for(int i=positives.length-1;i > 0; i -= 2) {
                sum += positives[i]*positives[i-1];
            }
        }
        else {
            for(int i=positives.length-1;i > 1; i -= 2) {
                sum += positives[i]*positives[i-1];
            }
        }

        if(negatives.length%2 == 0) {
            for(int j=0; j<negatives.length-1;j+=2) {
                sum += negatives[j]*negatives[j+1];
            }
        }
        else {
            for(int j=0; j<negatives.length-2;j+=2) {
                sum += negatives[j]*negatives[j+1];
            }
        }

        if(negatives.length%2 != 0 && positives.length%2 != 0)
            sum += negatives[negatives.length-1]*positives[0];
        else if(negatives.length%2 != 0)
            sum += negatives[negatives.length-1];
        else if(positives.length%2 != 0)
            sum += positives[0];

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(productSum(new int[]{4, 8, 3, -5, -2}));
    }
}
