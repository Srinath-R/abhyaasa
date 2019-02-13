package sri.sort;

public class Sort {
    public void sort () {
        int[] unsorted = {10,3,56,77,23,43,64,53,56,81,100};

        quickSort(unsorted,0,unsorted.length);
    }

    private void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr,low,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];

        for(int j=low;j < high;j++) {
            if(arr[j] <= pivot) {
                i+=1;
                int temp = arr[j];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
