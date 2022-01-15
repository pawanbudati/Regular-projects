/*
addFirst     : Adds an item at first node.
addLast      : Adds an item at last node.
removeFirst  : Removes the first node of list.
removeLast   : Removes the last node of list.
contains     : Checks item presence in list.
indexOf      : Returns the index of item in list. Return -1 if item is not present in list.
 */

public class LinkedList {
    private int length;
    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        length++;
    }

    public void print() {
        if (isEmpty())
            System.out.println("List is empty.");
        else {
            Node temp = first;
            while (temp != last) {
                System.out.print(temp.value + "->");
                temp = temp.next;
            }
            if (last != null)
                System.out.println(last.value);
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        length++;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int item) {
        int n = 0;
        var temp = first;
        while (temp != null) {
            if (temp.value == item)
                return n;
            n++;
            temp = temp.next;
        }
        return -1;
    }

    public void removeFirst() {
        if (isEmpty() == false) {
            length--;
            first = first.next;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot remove from empty list.");
        else {
            if (first == last)
                removeFirst();
            else {
                length--;
                var node = getPrevious(last);
                node.next = null;
                last = node;
            }
        }
    }

    public int size() {
        return length;
    }

    public void info() {
        System.out.println("First -> " + first.value);
        System.out.println("Last  -> " + last.value);
        System.out.println("First=Last->" + (first.next == null));
    }

    public void insert(int position, int item) {
        var node = new Node(item);
        var temp = first;
        if (position > length - 1) {
            throw new IllegalArgumentException("List index out of range.");
        } else if (position == 0)
            addFirst(item);
        else if (first != null) {
            for (int i = 1; i < position; i++)
                temp = temp.next;
            node.next = temp.next;
            temp.next = node;
        }
    }

    private Node getPrevious(Node node) {
        var temp = first;
        if (node != first)
            while (temp.next != node)
                temp = temp.next;
        return temp;
    }

    public int[] toArray() {
        int[] arr = new int[length];
        var temp = first;
        for (int i = 0; i < length; i++) {
            arr[i] = temp.value;
            temp = temp.next;
        }
        return arr;
    }

    public void reverse() {
        if (isEmpty() || first == last)
            return;
        if (length == 2) {
            var temp = first;
            first = last;
            first.next = temp;
            last = temp;
        } else {
            var p = first;
            var c = p.next;
            while (c != null) {
                var n = c.next;
                c.next = p;
                p = c;
                c = n;
            }
            last = first;
            first = p;

        }

    }

    public int getNodefromEnd(int i) {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot get item from empty list.");
        if (i <= 0 || i > length)
            throw new IllegalArgumentException("Item position out of range.");
        if (i == 1)
            return last.value;
        if (i == length)
            return first.value;
        var temp = first;
        for (int f = 0; f < length - i; f++)
            temp = temp.next;
        return temp.value;
    }
}
