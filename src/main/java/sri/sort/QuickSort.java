package sri.sort;



import java.util.Arrays;

public class QuickSort {
    public void  sort(int [] unsorted) {
        quickSort(unsorted,0,unsorted.length-1);
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    private void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            //partitioned index
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for(int j=low;j<high;j++) {
            if(arr[j] <= pivot) {
                i+=1;
                //swap i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
            }
        }
        //swap pivot with arr[i+1]
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

}
