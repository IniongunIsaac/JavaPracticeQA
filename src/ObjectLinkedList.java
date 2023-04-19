public class ObjectLinkedList {
    private ObjectNode head;

    public void add(Object value) {
        ObjectNode newNode = new ObjectNode(value);
        newNode.setNext(head);
        head = newNode;
    }

    public boolean find(Object value) {
        if (isEmpty()) {
            return false;
        }

        ObjectNode current = head;

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

        ObjectNode current = head;
        StringBuilder value = new StringBuilder();

        while (current != null) {
            value.append(current).append(", ");
            current = current.getNext();
        }

        return value.toString();
    }

    private boolean isEmpty() {
        return head == null;
    }
}
