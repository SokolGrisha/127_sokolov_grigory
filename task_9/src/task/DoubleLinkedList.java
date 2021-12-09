package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleLinkedListItem first;
    private DoubleLinkedListItem last;
    private int size = 0;

    public DoubleLinkedList() {
    }

    public DoubleLinkedListItem findFirstItem(T data) {
        DoubleLinkedListItem item;
        for(item = this.first; item.getData() != data; item = item.getNext()) {
        }

        return item;
    }

    public DoubleLinkedListItem findLastItem(T data) {
        DoubleLinkedListItem item;
        for(item = this.last; item.getData() != data; item = item.getPrev()) {
        }

        return item;
    }

    public void insertAfter(DoubleLinkedListItem item, T data) {
        DoubleLinkedListItem newItem = new DoubleLinkedListItem(data);
        if (item == null && this.size == 0) {
            this.first = newItem;
            this.last = newItem;
        } else if (item == null && this.size != 0) {
            this.insertBefore(this.first, data);
            --this.size;
        } else if (item.getNext() == null) {
            item.setNext(newItem);
            newItem.setPrev(item);
            this.last = newItem;
        } else {
            newItem.setNext(item.getNext());
            newItem.setPrev(item);
            item.getNext().setPrev(newItem);
            item.setNext(newItem);
        }

        ++this.size;
    }

    public void insertBefore(DoubleLinkedListItem item, T data) {
        DoubleLinkedListItem newItem = new DoubleLinkedListItem(data);
        if (item == null && this.size == 0) {
            this.first = newItem;
            this.last = newItem;
        } else if (item == null && this.size != 0) {
            this.insertAfter(this.last, data);
            --this.size;
        } else if (item.getPrev() == null) {
            item.setPrev(newItem);
            newItem.setNext(item);
            this.first = newItem;
        } else {
            newItem.setPrev(item.getPrev());
            newItem.setNext(item);
            item.getPrev().setNext(newItem);
            item.setPrev(newItem);
        }

        ++this.size;
    }

    public void remove(DoubleLinkedListItem item) {
        if (item.getNext() == null && item.getPrev() == null) {
            this.last = null;
            this.first = null;
        } else if (item.getNext() == null) {
            item.getPrev().setNext((DoubleLinkedListItem)null);
            this.last = item.getPrev();
        } else if (item.getPrev() == null) {
            item.getNext().setPrev((DoubleLinkedListItem)null);
            this.first = item.getNext();
        } else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext((DoubleLinkedListItem)null);
            item.setPrev((DoubleLinkedListItem)null);
        }

        --this.size;
    }

    public int getSize() {
        return this.size;
    }

    public DoubleLinkedListItem getFirst() {
        return this.first;
    }

    public DoubleLinkedListItem getLast() {
        return this.last;
    }
}
