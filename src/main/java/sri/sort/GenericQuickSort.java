package sri.sort;

import java.util.Arrays;

public class GenericQuickSort {

    public <T extends Comparable<T>> void sort(T[] unsorted) {
        System.out.println("Input array is >>>>>>>>>");
        Arrays.stream(unsorted).forEach(System.out::println);
        quickSort(unsorted,0,unsorted.length-1);
        System.out.println("Sorted array >>>>>>>>>>>");
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    private <E extends Comparable<E>> void quickSort(E[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private <E extends Comparable<E>> int partition(E[] arr, int low, int high) {
        E pivot = arr[high];
        //lower index
        int i = low-1;

        for(int j=low;j<high;j++) {
            if(arr[j].compareTo(pivot) < 1) {
                //swap lower index element and j
                i+=1;
                E temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //swap lower element and pivot element
        //i will point nearest lesser neighbour to pivot
        //pivot should come next to i
        E temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        //return i+1 which will be pivot index
        return i+1;
    }
}
