package sri.sort;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class GenericMergeSort {
    /**
     * This method will sort an array using merge sort using default ordering of the elements.
     * @param <T> Type of the array elements.Each element must implement <tt>java.lang.Comparable</tt>
     * @param unsorted Array to be sorted.
     */
    public <T extends Comparable<T>> void sort(@NotNull T[] unsorted) {
        System.out.println("Given array is :");
        Stream.of(unsorted).forEach(System.out::println);
        mergeSort(unsorted,0,unsorted.length-1);
        System.out.println("Sorted array :");
        Stream.of(unsorted).forEach(System.out::println);
    }

    private <E extends Comparable<E>>void mergeSort(@NotNull E[] array, int left, int right) {
        if(left < right) {
            int mid = (right + left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private <E extends Comparable<E>> void merge(@NotNull E[] array, int left, int mid, int right) {
        int leftRange = mid-left+1;
        int rightRange = right-mid;

        E leftArr[] = (E[]) Array.newInstance(array[left].getClass(),leftRange);
        E rightArr[] = (E[]) Array.newInstance(array[left].getClass(),rightRange);
        System.arraycopy(array,left,leftArr,0,leftRange);
        System.arraycopy(array,mid+1,rightArr,0,rightRange);

        int i=0,j=0,k=left;
        while (i < leftRange && j < rightRange) {
            if(leftArr[i].compareTo(rightArr[j]) < 1) {
                array[k] = leftArr[i];
                i++;
            }else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i<leftRange) {
            array[k++] = leftArr[i++];
        }
        while (j<rightRange) {
            array[k++] = rightArr[j++];
        }
    }
}
