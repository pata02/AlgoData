public class DoublyList {
    Node first;
    
    public class Node {
        int value;
        Node next;
        Node prev;

        Node(int val, Node tl, Node prv) {
            value = val;
            next = tl;
            prev = prv;
        }
    }


    public DoublyList() {
        first = null;
    }

    public Node add(int item) {
        Node current = first;

        if (current == null) {
            first = new Node(item, null, null);
            return first;
        } else {
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(item, null, current);
            return current.next;
        }

        
    }

    public void insert(Node item) {
        item.prev = null;
        item.next = first;

        first.prev = item;
        first = item;
    }

    public void unlink(Node item) {

        if (item == first) {
            first = first.next;
            first.prev = null;
            first.next.prev = first;
        } else {
            if (item.next != null) {
                item.prev.next = item.next;
                item.next.prev = item.prev;
            } else {
                item.prev.next = null;
            }
        }
    }

    public void printList() {
        Node current = first;

        while (current != null) {
            if (current.prev != null && current.next != null) {
                System.out.println("prev:" + current.prev.value + " Val:" + current.value + " Nxt:" + current.next.value);
                current = current.next;

            } else if (current.prev != null && current.next == null) {
                System.out.println("prev:" + current.prev.value + " Val:" + current.value + " Nxt:N");
                current = current.next;

            } else if (current.prev == null && current.next != null) {
                System.out.println("prev:N" + " Val:" + current.value + " Nxt:" + current.next.value);
                current = current.next;

            } else if (current.prev == null && current.next == null) {
                System.out.println("prev:N" + " Val:" + current.value + " Nxt:N");
                current = current.next;
            } else {
                System.out.println("ERROR");
                current = current.next;
            }
        }
    }

    public int length() {
        Node current = first;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public boolean find(int item) {
        Node current = first;

        while (current != null) {
            if (current.value == item)
                return true;
            current = current.next;
        }

        return false;
    }

    public void remove(int item) {
        Node current = first;
        Node behindCurr = null;

        if (first.value == item) {
            first = first.next;
            first.prev = null;
            first.next.prev = first;
            return;
        }

        while (current != null) {

            if (current.value == item) {
                if (current.next != null) {
                    behindCurr.next = current.next;
                    current.next.prev = behindCurr;
                } else {
                    behindCurr.next = null;
                    ;
                }
                return;
            }

            behindCurr = current;
            current = current.next;
        }
    }

    public void append(DoublyList b) {
        Node nxt = this.first;

        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b.first;
    }

}