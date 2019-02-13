package sri.gs;

import java.util.LinkedList;
import java.util.List;

public class Prog1 {

    public String collapseString(String inputString) {
        if (inputString != null && inputString.isEmpty())
            return "";

        char prev, current;
        prev = inputString.charAt(0);
        int count = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < inputString.length(); i++) {
            current = inputString.charAt(i);
            if (current == prev)
                count++;
            else {
                ans.append(count + String.valueOf(prev));
                count = 1;
                prev = current;
            }
        }
        ans.append(count + String.valueOf(prev));
        return ans.toString();
    }

    public static int requiredAmountAtStart(List<Integer> netSaving) {
        int sum= 0;
        int x = 0;
        for(int j : netSaving) {
            sum+=j;

            if(sum<=0)
                x+=(Math.abs(sum)+1);
        }
        return x;
    }

    static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int n;
        int count = 0;
        for(int i=y; i<=z; i++) {
            n = x * i;
            List<Integer> nDigits = getDigits(n);
            String yStr = Integer.toString(i);
            if(!hasDigits(yStr,nDigits))
                count+=1;
        }
        return count;
    }

    static boolean hasDigits(String yStr, List<Integer> nDigits) {
        for(Integer i : nDigits) {
            if(yStr.contains(Integer.toString(i))) {
                return true;
            }
        }
        return false;
    }

    static List<Integer> getDigits(int number) {
        List<Integer> digits = new LinkedList<>();
        collectDigits(number,digits);
        return digits;
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }

    public static long calculatePossibleCombinations(String inputStr) {
        long[] count = new long[inputStr.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= inputStr.length(); i++)
        {
            count[i] = 0;
            if (inputStr.charAt(i-1) > '0')
                count[i] = count[i - 1];
            if (inputStr.charAt(i-2) == '1' || (inputStr.charAt(i-2) == '2' && inputStr.charAt(i-1) < '7'))
                count[i] += count[i - 2];
        }
        return count[inputStr.length()];
    }

    public static void main(String[] args) {
        System.out.println(nonRepeatingDigitProductCount(2,10,15));
    }
}
