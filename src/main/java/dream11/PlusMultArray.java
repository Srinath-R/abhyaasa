package dream11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusMultArray {
    public String plusMult(List<Integer> A) {
        int evenSum = (int) (sumProd(A,0,0,0) % 2);
        int oddSum = (int) (sumProd(A,1,0,0) % 2);

        if(evenSum == oddSum)
            return "NEUTRAL";
        if(evenSum > oddSum)
            return "EVEN";
        else
            return "ODD";
    }

    public long sumProd(List<Integer> arr,int i,int step,long sum) {
        if(i == 0 || i == 1) {
            return sumProd(arr,i+2,step+1,arr.get(i));
        }
        if(i < arr.size()) {
            if((step & 1) == 0)
                return sumProd(arr,i+2,step+1,sum+arr.get(i));
            else
                return sumProd(arr,i+2,step+1,sum*arr.get(i));
        }
        else
            return sum;
    }


    public static void finalPrice(List<Integer> prices) {
        Integer [] arr = prices.toArray(new Integer[prices.size()]);
        int finalPrice = 0;
        List<Integer> nonDiscounted = new ArrayList<>();
        for(int i=0; i<arr.length-1;i++) {
            Integer discount = getDiscount(arr, arr[i], i + 1);
            if(arr[i] >= discount)
                finalPrice += discount;
            if(arr[i] == discount) {
                nonDiscounted.add(i);
            }
        }
        finalPrice += arr[arr.length-1];
        nonDiscounted.add(arr.length-1);
        System.out.println(finalPrice);
        System.out.println(nonDiscounted.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    private static Integer getDiscount(Integer[] arr,Integer ref ,Integer start) {
        int min = arr[start];
        if(start < arr.length) {
            for(int i=start;i<arr.length;i++) {
                if(ref == arr[i]) {
                    return 0;
                }
                min = (arr[i] <= min) ? arr[i] : min;
            }
        }
        return (min < ref) ? ref - min : ref;
    }

    public static void main(String[] args) {
        //finalPrice(Arrays.asList(5,1,3,4,6,2));
        String result = new PlusMultArray().plusMult(Arrays.asList(1,2,3,4,5,7,7));
        System.out.println(result);
    }
}
