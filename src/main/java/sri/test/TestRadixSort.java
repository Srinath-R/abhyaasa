package sri.test;

import sri.sort.RadixSort;

public class TestRadixSort {
    public static void main(String[] args) {
        RadixSort sorter = new RadixSort();
        sorter.sort(new int[] {170, 45, 75, 90, 802, 24, 2, 66});
    }
}
