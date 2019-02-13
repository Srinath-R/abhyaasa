package sri.test;

import java.util.Arrays;

public class Soln {
    public void quickSort(int[] arr,int low,int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }

    private int partition(int[] arr,int low,int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<high;j++) {
            if(arr[j] < pivot) {
                i+=1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public void mergeSort(int[] arr,int low,int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(arr,low,mid-1);
            mergeSort(arr,mid,high);
            merge(arr,low,mid,high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int left = mid-low+1;
        int right = high-mid;

        int[] leftArr = new int[left];
        int[] rightArr = new int[right];
        System.arraycopy(arr,left,leftArr,0,left);
        System.arraycopy(arr,mid+1,rightArr,0,right);

        int i=0,j=0,k=low;

        while(i<left && j<right) {
            if(leftArr[i] <=rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < left) {
            arr[k++] = leftArr[i++];
        }

        while ((j < right)) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int [] unsorted = {6,8,4,88,3,77,8,99,234};
        new Soln().quickSort(unsorted,0,unsorted.length-1);
        Arrays.stream(unsorted).forEach(System.out::println);
    }
}
