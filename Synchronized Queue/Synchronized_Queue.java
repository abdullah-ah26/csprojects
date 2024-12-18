package lab5;

public class Synchronized_Queue<T> {
    private Node<T> front;
    private int size;
    private final int maxSize;
    
    public Synchronized_Queue(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.front = null;
    }
    
    public synchronized boolean push(T value) {
        if (size >= maxSize) {
            return false; 
        }
        
        Node<T> newNode = new Node<>();
        newNode.data = value;
        
        if (front == null) {
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }
    
    public synchronized T pop() {
        if (front == null) {
            return null; 
        }
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }
}