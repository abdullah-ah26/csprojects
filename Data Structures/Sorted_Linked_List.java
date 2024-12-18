public class Sorted_Linked_List<T extends Comparable<T>> {
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>();
        newNode.data = value;

        if (head == null || value.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null && value.compareTo(current.next.data) > 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public T remove(T value) {
        if (head == null) return null;
        
        if (head.data.equals(value)) {
            T data = head.data;
            head = head.next;
            return data;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            T data = current.next.data;
            current.next = current.next.next;
            return data;
        }
        return null;
    }

    public boolean search(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public String printAllValues() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
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

    private String printHelper(Node<T> node) {
        if (node == null) return "";
        return node.data + " " + printHelper(node.next);
    }
}