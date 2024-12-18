public class Stack<T> {
    private Node<T> top;

    public void push(T value) {
        Node<T> newNode = new Node<>();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top == null) return null;
        T data = top.data;
        top = top.next;
        return data;
    }

    public T top() {
        if (top == null) return null;
        return top.data;
    }
}