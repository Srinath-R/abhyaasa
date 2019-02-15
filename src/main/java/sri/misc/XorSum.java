package sri.misc;

public class XorSum {
    public static long xorSum(int[] input) {
        long sum = 0;
        for(int i=0; i<input.length-1;i++) {
            int j = i;
            while(j < input.length) {
                sum += xor(input,i,j);
                j++;
            }
        }
        sum+=input[input.length - 1];
        return sum;
    }

    private static long xor(int[] input, int start, int end) {
        long xorSum = 0;
        for(int k = start; k <= end; k++) {
            xorSum ^= input[k];
        }
        return xorSum;
    }

    public static void main(String[] args) {
        System.out.println(xorSum(new int[] {3, 8, 13}));
    }
}
