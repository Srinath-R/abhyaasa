package sri.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RadixSort {

    public void sort(int[] unsorted) {
        System.out.println("Given unsorted array is >>>>>>>>>");
        IntStream.of(unsorted).forEach(System.out::println);
        radixSort(unsorted, unsorted.length);
        System.out.println("sorted array is >>>>>>>>>");
        IntStream.of(unsorted).forEach(System.out::println);
    }

    private void radixSort(int[] arr, int n) {
        int max = IntStream.of(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    private void countSort(int[] arr, int n, int exp) {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        //store number of occurrences in count
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        //cumulative update count array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

}
