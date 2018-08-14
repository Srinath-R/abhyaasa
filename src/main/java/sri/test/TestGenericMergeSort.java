package sri.test;

import sri.sort.GenericMergeSort;

public class TestGenericMergeSort {
    public static void main(String[] args) {
        GenericMergeSort sorter = new GenericMergeSort();
        sorter.sort(new String [] {"dog","zebra","ball","cat","apple"});
    }
}
