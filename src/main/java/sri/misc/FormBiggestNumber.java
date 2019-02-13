package sri.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *  <a>https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number</a>
 */
public class FormBiggestNumber {

    public static String formLargest(List<String> numbers) {
        System.out.println("Before sort: "+numbers);
        numbers.sort((x, y) -> {
            String xy = x + y;
            String yx = y + x;
            if (xy.equals(yx)) return 0;
            else return xy.compareTo(yx) > 0 ? -1 : 1;
        });
        System.out.println("After sort: "+numbers);
        return String.join("",numbers);
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        System.out.println(formLargest(arr));
    }
}
