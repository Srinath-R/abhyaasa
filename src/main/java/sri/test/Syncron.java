package sri.test;

import java.util.Arrays;

public class Syncron {

    // Complete the counts function below.
    static int[] counts1(int[] nums, int[] maxes) {
        int[] counts = new int[maxes.length];
        for(int i=0; i<maxes.length;i++) {
            int maxCount = 0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j] <= maxes[i])
                    maxCount++;
            }
            counts[i] = maxCount;
        }
        return counts;
    }

    static int[] counts(int[] nums, int[] maxes) {
        int[] counts = new int[maxes.length];
        Arrays.sort(nums);
        for(int i=0; i<maxes.length;i++) {
            int pos = Arrays.binarySearch(nums,maxes[i]);
            if(pos >= 0) {
                counts[i] = pos+1;
            }
            else {
                int maxCount = 0;
                int j = 0;
                while (j < nums.length && nums[j] <= maxes[i]) {
                    maxCount++;
                    j++;
                }
                counts[i] = maxCount;
            }
        }
        return counts;
    }

    private static int binarySearch(int[] A,int left,int right, int k) {
        if(left < right){
            int guess = (left+right)/2;

            if(k == A[guess])
                return guess;
            if(A[guess] > k)
                return binarySearch(A,left,guess-1, k);
            else
                return binarySearch(A,guess+1,right, k);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(counts(new int[]{1,4,2,4},new int[]{3,5}));
    }


}
