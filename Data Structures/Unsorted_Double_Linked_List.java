public class Unsorted_Double_Linked_List<T> {
    private DoubleNode<T> head;
    private int size;

    public int size() {
        return size;
    }

    public T get(int index) {
        DoubleNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void insert(T value, int index) {
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.data = value;
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
        } else {
            DoubleNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        DoubleNode<T> current = head;
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.prev != null) current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
        }
        size--;
        return current.data;
    }

    public String printAllValues() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    public String printAllValuesRecursion() {
        if (head == null) return "";
        return printHelper(head).trim();
    }

    private String printHelper(DoubleNode<T> node) {
        if (node == null) return "";
        return node.data + " " + printHelper(node.next);
    }
}