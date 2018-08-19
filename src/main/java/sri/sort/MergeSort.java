package sri.sort;

import java.util.stream.IntStream;

public class MergeSort {
    public void sort(int[] unsorted) {
        System.out.println("Given unsorted array is >>>>>>>>>");
        IntStream.of(unsorted).forEach(System.out::println);
        mergeSort(unsorted, 0, unsorted.length - 1);
        System.out.println("sorted array is >>>>>>>>>");
        IntStream.of(unsorted).forEach(System.out::println);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //create two temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr,left,leftArr,0,n1);
        System.arraycopy(arr,mid+1,rightArr,0,n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of left array
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        //copy remaining elements of  right array
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}
