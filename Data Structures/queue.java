public class queue<T> {
    private Node<T> front;

    public void push(T value) {
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
    }

    public T pop() {
        if (front == null) return null;
        T data = front.data;
        front = front.next;
        return data;
    }

    public T top() {
        if (front == null) return null;
        return front.data;
    }
}