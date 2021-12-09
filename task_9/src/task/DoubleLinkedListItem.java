package task;

public class DoubleLinkedListItem<T extends Comparable<T>> {
    private T data;
    private DoubleLinkedListItem next;
    private DoubleLinkedListItem prev;

    public DoubleLinkedListItem(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public DoubleLinkedListItem getNext() {
        return this.next;
    }

    public DoubleLinkedListItem getPrev() {
        return this.prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DoubleLinkedListItem next) {
        this.next = next;
    }

    public void setPrev(DoubleLinkedListItem prev) {
        this.prev = prev;
    }
}
