public class Queue {
    Node head;
    Node last;

    private class Node {
        BinaryTree.Node item;
        Node next;
        
        private Node(BinaryTree.Node item, Node nxt) {
            this.item = item;
            this.next = nxt;
        }
    }

    public Queue() {
       head = null;
    }
    
    public void add(BinaryTree.Node item) {
        if (head == null) {
            head = new Node(item, null);
            last = head;
        } else {
            last.next = new Node(item, null);
            last = last.next;
        }
        
        /*Node current = head;
        
        if (head == null) {
            head = new Node(item, null);
            System.out.println("Head null adding " + head.item);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item, null);
            System.out.println("Added:" + current.next.item);
            
        }*/
    }

    public BinaryTree.Node remove() {
        BinaryTree.Node retVal = head.item;
        head = head.next;
        return retVal;
    }

    public int length(){
        Node current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }
    public void printAll(){
        Node current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

}