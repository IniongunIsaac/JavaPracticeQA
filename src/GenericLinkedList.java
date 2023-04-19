public class GenericLinkedList<T> {
    private GenericNode<T> head;

    public void add(T value) {
        GenericNode<T> newNode = new GenericNode<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    public boolean find(T value) {
        if (isEmpty()) {
            return false;
        }

        GenericNode<T> current = head;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        GenericNode<T> current = head;
        StringBuilder buffer = new StringBuilder();

        while (current != null) {
            buffer.append(current).append(", ");
            current = current.getNext();
        }

        return buffer.toString();
    }

    private boolean isEmpty() {
        return head == null;
    }
}
