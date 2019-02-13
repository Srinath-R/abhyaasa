package sri.gs;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [ [ "Bobby", "87" ],
 **    [ "Charles", "100" ],
 **    [ "Eric", "64" ],
 **    [ "Charles", "22" ] ].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class Solution
{
    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores)
    {
        int maxAvg = 0;
        Map<String,List<Integer>> marksMap = new HashMap<>();
        for(String[] tuple : scores)
        {
            if(marksMap.containsKey(tuple[0])) {
                System.out.println(marksMap);
                List<Integer> marksList = marksMap.get(tuple[0]);
                marksList.add(Integer.parseInt(tuple[1]));
            }
            else {
                List<Integer> marksList = new ArrayList<>();
                marksList.add(Integer.parseInt(tuple[1]));
                marksMap.put(tuple[0],marksList);
            }
        }
        maxAvg = marksMap.entrySet().stream().map(Map.Entry::getValue)
                .mapToInt(Solution::avgUtil)
                .max()
                .orElse(0);
        System.out.println("Marks: " + marksMap);
        System.out.println("Max: " + maxAvg);
        return maxAvg;
    }

    public static int avgUtil(List<Integer> marks) {
        return (int) marks.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // TODO: implement more test cases
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };

        return bestAverageGrade(tc1) == 87;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}

