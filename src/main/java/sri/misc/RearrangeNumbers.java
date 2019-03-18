package sri.misc;

import java.util.Arrays;

public class RearrangeNumbers {
    public static void rearrange(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == Integer.MIN_VALUE) {
                int[] temp = Arrays.copyOf(arr, n);
                for (int k = 1; k <= j; k++) {
                    temp[k] = arr[k - 1];
                }
                temp[0] = 1;
                arr = temp;
            }
        }
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        rearrange(new int[]{22, 1, 34, 22, 16}, 22);
        rearrange(new int[]{3, 5, 3, 5, 5, 11, 5}, 5);
    }
}
