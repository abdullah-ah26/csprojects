package lab5;

public class Producer implements Runnable {
    private final Synchronized_Queue<Integer> queue;
    private final int delay;
    private static int value = 0;

    public Producer(Synchronized_Queue<Integer> queue, int delay) {
        this.queue = queue;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized(Producer.class) {
                    int nextValue = value + 1;
                    if (queue.push(nextValue)) {  // Only increment if successfully pushed
                        value = nextValue;
                    }
                }
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}