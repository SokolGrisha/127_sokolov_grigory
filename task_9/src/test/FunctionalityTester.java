//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package test;

import task.DoubleLinkedList;
import task.DoubleLinkedListItem;
import task.DoubleLinkedListSorter;

public class FunctionalityTester {
    private StringBuilder protocol = new StringBuilder();
    private int testNum;
    private boolean allOk;

    public FunctionalityTester() {
    }

    public String getProtocol() {
        return this.protocol.toString();
    }

    public boolean testClass(String className) {
        this.protocol = new StringBuilder();
        this.testNum = 1;
        this.allOk = true;
        byte var3 = -1;
        switch(className.hashCode()) {
            case -1861922660:
                if (className.equals("task.DoubleLinkedListSorter")) {
                    var3 = 2;
                }
                break;
            case -1307006351:
                if (className.equals("task.DoubleLinkedList")) {
                    var3 = 1;
                }
                break;
            case 1208940836:
                if (className.equals("task.DoubleLinkedListItem")) {
                    var3 = 0;
                }
        }

        boolean var10000;
        switch(var3) {
            case 0:
                var10000 = this.testDoubleLinkedListItem();
                break;
            case 1:
                var10000 = this.testDoubleLinkedList();
                break;
            case 2:
                var10000 = this.testDoubleLinkedListSorter();
                break;
            default:
                var10000 = false;
        }

        return var10000;
    }

    void writeProto(boolean testRes) {
        this.allOk = this.allOk && testRes;
        this.protocol.append("\tТест ").append(this.testNum++).append(": ").append(testRes ? "ОК\n" : "Ошибка\n");
    }

    void protoException() {
        this.protocol.append("\tТест ").append(this.testNum++).append(" упал с ошибкой! ").append("Ошибка\n");
    }

    private boolean testDoubleLinkedListItem() {
        DoubleLinkedListItem<Integer> item1 = new DoubleLinkedListItem(10);
        this.writeProto(item1.getPrev() == null);
        this.writeProto(item1.getNext() == null);
        this.writeProto((Integer)item1.getData() == 10);
        DoubleLinkedListItem<Integer> item2 = new DoubleLinkedListItem(20);
        item1.setNext(item2);
        item2.setPrev(item1);
        this.writeProto(item1.getPrev() == null);
        this.writeProto(item1.getNext() == item2);
        this.writeProto(item2.getPrev() == item1);
        this.writeProto(item2.getNext() == null);
        this.writeProto((Integer)item2.getData() == 20);
        return this.allOk;
    }

    private <T extends Comparable<T>> boolean listEquals(DoubleLinkedList<T> actual, Object[] expected) {
        if (actual.getSize() != expected.length) {
            return false;
        } else {
            DoubleLinkedListItem worker = actual.getFirst();

            for(int i = 0; i < expected.length; ++i) {
                if (!worker.getData().equals(expected[i])) {
                    return false;
                }

                worker = worker.getNext();
            }

            return true;
        }
    }

    private boolean testDoubleLinkedList() {
        try {
            DoubleLinkedList<String> list = new DoubleLinkedList();
            this.writeProto(list.getSize() == 0);
            this.writeProto(list.getFirst() == null);
            this.writeProto(list.getLast() == null);
            list.insertAfter((DoubleLinkedListItem)null, "str1");
            this.writeProto(list.getSize() == 1);
            this.writeProto(list.getFirst().getData().equals("str1"));
            this.writeProto(list.getLast().getData().equals("str1"));
            this.writeProto(list.getFirst() == list.getLast());
            DoubleLinkedListItem item = list.findFirstItem("str1");
            this.writeProto(item.getData().equals("str1"));
            this.writeProto(this.listEquals(list, new Object[]{"str1"}));
            list.remove(item);
            this.writeProto(list.getSize() == 0);
            this.writeProto(list.getFirst() == null);
            this.writeProto(list.getLast() == null);
            list.insertAfter((DoubleLinkedListItem)null, "center");
            item = list.findFirstItem("center");
            list.insertAfter(item, "last");
            list.insertAfter((DoubleLinkedListItem)null, "first");
            this.writeProto(this.listEquals(list, new Object[]{"first", "center", "last"}));
            list.insertAfter(item, "center2");
            this.writeProto(this.listEquals(list, new Object[]{"first", "center", "center2", "last"}));
            list.remove(list.findFirstItem("center2"));
            this.writeProto(this.listEquals(list, new Object[]{"first", "center", "last"}));
            list.remove(list.findFirstItem("first"));
            this.writeProto(this.listEquals(list, new Object[]{"center", "last"}));
            list.remove(list.findFirstItem("last"));
            this.writeProto(this.listEquals(list, new Object[]{"center"}));
            list.remove(list.findFirstItem("center"));
            this.writeProto(this.listEquals(list, new Object[0]));
            list.insertBefore((DoubleLinkedListItem)null, "center");
            item = list.findFirstItem("center");
            list.insertBefore((DoubleLinkedListItem)null, "last");
            list.insertBefore(item, "first");
            list.insertBefore(item, "center2");
            this.writeProto(this.listEquals(list, new Object[]{"first", "center2", "center", "last"}));
            list.remove(list.findFirstItem("center2"));
            this.writeProto(this.listEquals(list, new Object[]{"first", "center", "last"}));
            list.remove(list.findFirstItem("first"));
            this.writeProto(this.listEquals(list, new Object[]{"center", "last"}));
            list.remove(list.findFirstItem("last"));
            this.writeProto(this.listEquals(list, new Object[]{"center"}));
            list.remove(list.findFirstItem("center"));
            this.writeProto(this.listEquals(list, new Object[0]));
            list.insertAfter((DoubleLinkedListItem)null, "item");
            item = list.findFirstItem("item");
            list.insertAfter(item, "item");
            list.insertAfter(item, "item");
            list.insertAfter(item, "item");
            list.insertAfter(item, "item");
            this.writeProto(list.findFirstItem("item") == list.getFirst());
            this.writeProto(list.findLastItem("item") == list.getLast());
        } catch (Exception var3) {
            this.protoException();
            return false;
        }

        return this.allOk;
    }

    private boolean testDoubleLinkedListSorter() {
        try {
            DoubleLinkedList<String> list = new DoubleLinkedList();
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[0]));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "d");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"d"}));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "d");
            list.insertAfter((DoubleLinkedListItem)null, "d");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"d", "d"}));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "d");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "b");
            list.insertAfter((DoubleLinkedListItem)null, "r");
            list.insertAfter((DoubleLinkedListItem)null, "w");
            list.insertAfter((DoubleLinkedListItem)null, "x");
            list.insertAfter((DoubleLinkedListItem)null, "y");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"a", "b", "d", "r", "w", "x", "y"}));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "b");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"a", "a", "a", "a", "a", "a", "b"}));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "b");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"a", "a", "a", "a", "a", "a", "b"}));
            list = new DoubleLinkedList();
            list.insertAfter((DoubleLinkedListItem)null, "b");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            list.insertAfter((DoubleLinkedListItem)null, "a");
            DoubleLinkedListSorter.sort(list);
            this.writeProto(this.listEquals(list, new Object[]{"a", "a", "a", "a", "a", "a", "b"}));
        } catch (Exception var2) {
            this.protoException();
            return false;
        }

        return this.allOk;
    }
}
