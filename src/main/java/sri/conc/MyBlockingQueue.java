package sri.conc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyBlockingQueue<T> {
    private List<T> buffer = new LinkedList<>();
    private int capacity;

    public MyBlockingQueue() {
        this.capacity = 16;
    }

    public MyBlockingQueue(int size) {
        this.capacity = size;
    }

    public synchronized boolean enqueue(T val) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.format("%s: Buffer full waiting... :-(%n",Thread.currentThread().getName());
            wait();
        }
        if(buffer.isEmpty()) {
            System.out.format("%s: Adding to buffer and notifying all...%n",Thread.currentThread().getName());
            notifyAll();
        }
        return buffer.add(val);
    }

    public synchronized T dequeue() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.format("%s: Buffer empty waiting for data.. :-|%n",Thread.currentThread().getName());
            wait();
        }
        if(buffer.size() == capacity) {
            System.out.format("%s: Notifying everyone that queueu is getting freed...%n",Thread.currentThread().getName());
            notifyAll();
        }
        return buffer.remove(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBlockingQueue<?> that = (MyBlockingQueue<?>) o;
        return Objects.equals(buffer, that.buffer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buffer);
    }

    @Override
    public String toString() {
        return "MyBlockingQueue{" + buffer + '}';
    }
}
