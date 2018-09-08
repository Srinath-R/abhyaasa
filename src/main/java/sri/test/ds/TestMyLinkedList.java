package sri.test.ds;

import sri.ds.MyLinkedList;

public class TestMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("Test empty:");
        System.out.println(list);
        //Add few entries
        list.append("7");
        list.append("8");
        System.out.println("Test get first and last after append:");
        System.out.format("First: %s Last: %s \n",list.getFirstValue(),list.getLastValue());
        list.prepend("4");
        list.prepend("3");
        System.out.println("Test get first and last after prepend:");
        System.out.format("First: %s Last: %s \n",list.getFirstValue(),list.getLastValue());
        System.out.println("test append and prepend:");
        System.out.println(list);
        System.out.println("Test retrieval:");
        System.out.println(list.get(3));
        System.out.println(list.get(-1));
        System.out.println("Create a cycle in list.");
        list.loopFirstAndLast();
        System.out.println("Detect cycle.");
        System.out.println(list.hasCycle());


    }

}
