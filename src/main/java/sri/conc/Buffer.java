package sri.conc;

public class Buffer {
    private String message;
    private boolean empty;

    public Buffer() {
        empty = true;
    }

    public synchronized void write(String data) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.message = data;
        notifyAll();
    }

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return message;
    }
}
