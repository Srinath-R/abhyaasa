package sri.misc;

public class FindSingleOccurence {
    public static int findSingle(int[] input){
        int result = 0;
        for(int i=0; i<32; i++) {
            int sum = 0;
            int x = 1<<i;
            for(int j=0;j<input.length;j++) {
                if((input[j] & x) == x)
                    sum++;
            }
            if(sum % 3 != 0) {
                result |= x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSingle(new int[] {12, 1, 12,1, 1, 12, 2}));
    }
}
