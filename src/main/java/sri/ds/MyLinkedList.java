package sri.ds;

public class MyLinkedList<T> {
    private class Node<E> {
        private E value;
        private Node<E> next = null;
        Node(E value) {
            this.value = value;
        }

        Node<E> next() {
            return next;
        }

        void setNext(Node<E> next) {
            this.next = next;
        }

        E getValue() {
            return value;
        }

    }

    private Node<T> head=null;
    private Node<T> first = head;
    private Node<T> last = head;

    public T getFirstValue() {
        if(first != null)
            return first.getValue();
        else
            return null;
    }

    private void setFirst(Node<T> first) {
        this.first = first;
    }

    public T getLastValue() {
        if(last != null)
            return last.getValue();
        else
            return null;
    }

    private void setLast(Node<T> last) {
        this.last = last;
    }

    public void append(T value) {
        Node<T> cursor = this.head;
        if(cursor == null) {
            cursor = new Node<>(value);
            head = cursor;
            setFirst(head);
            setLast(head);
        }
        else {
            cursor = getLast();
            Node<T> node = new Node<>(value);
            cursor.setNext(node);
            setLast(node);
        }
    }

    private Node<T> getLast() {
        return this.last;
    }

    public void prepend(T value) {
        Node<T> cursor = this.head;
        if(cursor == null) {
            cursor = new Node<>(value);
            head = cursor;
            setFirst(head);
            setLast(head);
        }
        else {
            Node<T> newHead = new Node<>(value);
            newHead.setNext(getFirst());
            head = newHead;
            setFirst(head);
        }
    }

    private Node<T> getFirst() {
        return this.first;
    }

    public T get(int index) {
        T value = null;
        if(index == 0) {
            value = getFirstValue();
        }
        else {
            Node<T> cursor = getFirst();
            int level = 1;
            while(level <= index) {
                level++;
                if(cursor != null && cursor.next() != null) {
                    cursor = cursor.next();
                }
                else
                    break;
            }
            if(level-1 == index && cursor != null)
                value = cursor.getValue();
        }
        return value;
    }

    @Override
    public String toString() {
        return this.getContentsAsString();
    }

    private String getContentsAsString() {
        Node<T> cursor = getFirst();
        StringBuilder values = new StringBuilder();
        if(cursor == null) {
            values.append("List is empty.");
        }
        else {
            values.append(cursor.getValue());
            while (cursor.next() != null) {
                cursor = cursor.next();
                values.append(",").append(cursor.getValue());
            }
        }
        return values.toString().trim();
    }

    public void loopFirstAndLast() {
        getLast().setNext(getFirst());
    }

    public boolean hasCycle() {
        if(getFirst() == null || getFirst().next() == null)
            return false;
        Node<T> slow = getFirst();
        Node<T> fast = getFirst();

        while (slow != null && fast != null && fast.next() != null) {
            slow = slow.next();
            fast = fast.next().next();
            if(slow == fast)
                return true;
        }
        return false;
    }
}
