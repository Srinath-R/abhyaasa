package sri.ds;

import java.util.stream.IntStream;

public class ReverseLinkedList {
    public static class Node<E> {
        public E value;
        public Node<E> next;

        public Node() {
            this.next = null;
        }

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node<Integer> root;

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        //populate Linked list
        IntStream.range(1,6).forEach(i->{
            if(rll.root == null)
                rll.root = new Node<>(i);
            else {
                Node<Integer> currentNode = rll.root;
                while(currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = new Node<>(i);
            }
        });
        rll.printList();
        rll.reverse();
        rll.printList();
        rll.reverse();
        rll.printList();
    }

    private void reverse() {
        Node<Integer> newRoot = null;
        while (root != null) {
            Node<Integer> tempNode = root;
            root = root.next;
            if(newRoot == null) {
                newRoot = tempNode;
                newRoot.next = null;
            }
            else {
                tempNode.next = newRoot;
                newRoot = tempNode;
            }
        }
        root = newRoot;
    }

    private void printList() {
        System.out.println();
        if(root != null) {
            for(Node<Integer> cursor = root;cursor != null;cursor = cursor.next)
                System.out.format("%s->",cursor.value);
        }
        System.out.println();
    }
}
