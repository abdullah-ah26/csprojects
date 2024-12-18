package lab5;

public class Consumer implements Runnable {
    private final Synchronized_Queue<Integer> queue;
    private final int delay;
    
    public Consumer(Synchronized_Queue<Integer> queue, int delay) {
        this.queue = queue;
        this.delay = delay;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                Integer value = queue.pop();
                if (value != null) {
                    System.out.println(value);
                }
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}