package sri.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayManipulator {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        for(int i = 0;i < queries.length; i++) {
            addToArray(arr,queries[i][0],queries[i][1],queries[i][2]);
        }
        long max = arr[0];
        for(int k=1; k<arr.length ; k++) {
            if(arr[k] > max)
                max = arr[k];
        }
        return max;
    }

    static int maxSubsetSum(int[] arr) {
        int maxInclusive = arr[0];
        int maxExclusive = 0;
        int temp;
        for(int i=1; i<arr.length; i++) {
            //temp = (maxInclusive > maxExclusive)
        }
        return maxInclusive;
    }

    private static void addToArray(long[] array,int from, int to, long delta) {
        for(int i=from-1;i<to;i++) {
            array[i] += delta;
        }
    }

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src\\main\\resources\\input.txt");
        try(BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String[] nm = reader.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] queries = new int[m][3];
            for(int i=0; i<m ; i++) {
                String[] tmp = reader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(tmp[0]);
                queries[i][1] = Integer.parseInt(tmp[1]);
                queries[i][2] = Integer.parseInt(tmp[2]);
            }
            long startTime = System.currentTimeMillis();
            long result = arrayManipulation(n,queries);
            System.out.println(result);
            System.out.println("Ended at "+ (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
