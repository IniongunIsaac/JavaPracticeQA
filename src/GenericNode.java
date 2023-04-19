public class GenericNode<T> {
    private T value;
    private GenericNode<T> next;

    public GenericNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
