class LinkedList {
    Node first;
    Node current;

    public class Node {
        int value;
        Node next;

        Node(int val, Node tl) {
            value = val;
            next = tl;
        }
    }

    public LinkedList() {
        current = first;

        /*
         * for (int i = 0; i < n; i++) {
         * last = new Node(i, last);
         * }
         * first = last;
         */
    }

    /*
     * public void LinkedList() {
     * first = null;
     * current = first;
     * }
     */

    public void unlink(Node item) {
        current = first;
        Node behindCurr = null;

        if (first == item) {
            first = first.next;
            return;
        }

        while (current != null) {

            if (current == item) {
                if (current.next != null) {
                    behindCurr.next = current.next;
                } else {
                    behindCurr.next = current.next;
                }
                return;
            }

            behindCurr = current;
            current = current.next;
        }
    }

    public void push(LinkedList lst, int val) {
        lst.add(val);
    }

    public int pop(LinkedList lst) {
        current = lst.first;
        Node prev = null;
        int retVal;

        if (first.next == null) {
            retVal = first.value;
            first = null;
            return retVal;
        }

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        retVal = current.value;

        prev.next = null;
        return retVal;
    }

    public Node add(int item) {
        current = first;

        if (current == null) {
            first = new Node(item, null);
            return first;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item, null);
            return current.next;
        }

    }

    public void insert(Node item) {
        item.next = first;
        first = item;
        return;
    }

    public void printList() {
        current = first;

        while (current != null) {
            if (current.next != null) {
                System.out.println("Val:" + current.value + " Next:" + current.next.value);
                current = current.next;
            } else {
                System.out.println("Val:" + current.value + " Next:N" );
                current = current.next;
            }
        }
    }

    public int length() {
        current = first;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public boolean find(int item) {
        current = first;

        while (current != null) {
            if (current.value == item)
                return true;
            current = current.next;
        }

        return false;
    }

    public void remove(int item) {
        current = first;
        Node behindCurr = null;

        if (first.value == item) {
            first = first.next;
            return;
        }

        while (current != null) {

            if (current.value == item) {
                if (current.next != null) {
                    behindCurr.next = current.next;
                } else {
                    behindCurr.next = current.next;
                }
                return;
            }

            behindCurr = current;
            current = current.next;
        }
    }

    public void append(LinkedList b) {
        Node nxt = this.first;

        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b.first;
    }

}