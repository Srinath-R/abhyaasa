package sri.misc;

/*
    BoolletProblem link
    https://github.com/PuzzlesLab/UVA/blob/master/King/00637%20Booklet%20Printing.java

 */
public class PowerSum {
    public int powerSum(int x, int n) {
        return calc(x, n, 1, 0);
    }

    private int calc(int x, int n, int i, int sum) {
        // Initialize number of ways to express
        // x as n-th powers of different natural
        // numbers
        int ways = 0;

        // Calling power of 'i' raised to 'n'
        int p = (int) Math.pow(i, n);
        while (p + sum < x) {
            // Recursively check all greater values of i
            ways += calc(x, n, i + 1,
                    p + sum);
            i++;
            p = (int) Math.pow(i, n);
        }

        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + sum == x)
            ways++;

        // Return the final result
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(new PowerSum().powerSum(100, 2));
    }
}
