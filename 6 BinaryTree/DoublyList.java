public class DoublyList {
    Cell first;
    
    public class Cell {
        BinaryTree.Node value;
        Cell next;
        Cell prev;
        
        Cell(BinaryTree.Node val, Cell tl, Cell prv) {
            value = val;
            next = tl;
            prev = prv;
        }
    }

    public DoublyList() {
        first = null;
    }

    public void add(BinaryTree.Node item) {
        Cell current = first;

        if (current == null) {
            first = new Cell(item, null, null);
            //return first;
        } else {
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Cell(item, null, current);
            //return current.next;
        }

        
    }

    public int length() {
        Cell current = first;
        int counter = 0;

        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }
    public void push(BinaryTree.Node val) {
        add(val);
    }

    public BinaryTree.Node pop(DoublyList lst) {
        Cell current = lst.first;
        Cell prev = null;
        BinaryTree.Node retVal;

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

}