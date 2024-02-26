
/*public class Stack {
    int length;
    int sPointer;
    int[] stack;

    public Stack() {
        this.length = 2048;
        this.sPointer = -1;
        this.stack = new int[2048];
    }

    public void push(int val) {
        sPointer++;
        stack[sPointer] = val;
    }

    public int pop() {
        int tempHolder = stack[sPointer];
        sPointer--;
        return tempHolder;
    }
}
*/
public class Stack {
    int length;
    int sPointer;
    int[] stack;

    int counter = 0;

    public Stack() {
        this.length = 4;
        this.sPointer = -1;
        this.stack = new int[4];
    }

    private void stackExtender() {
        int[] temp = new int[length + length]; // Make double the size

        for (int i = 0; i < length; i++) { // Migrate
            temp[i] = stack[i];
        }

        stack = temp; // Replace new stack and length
        length = stack.length;
        //System.out.println("length: " + length);
    }

    private void shrinkCheck() {
        if (sPointer < length / 2) {

            //System.out.println("counter increase");
            counter++;
            if (counter >= 3) {
                stackShrinker();
                counter = 0;
                //System.out.println("counter reset");
            }

        } else {
            counter = 0;
            //System.out.println("counter reset");
        }
    }

    private void stackShrinker() {
        int[] temp = new int[length / 2]; // Make 75% the size
        //System.out.println(length);

        for (int i = 0; i < length / 2; i++) { // Migrate
            temp[i] = stack[i];
        }

        stack = temp; // Replace new stack and length
        length = stack.length;
        //System.out.println("Shrinking to " + length);
    }

    public void push(int val) {
        sPointer++; // Increase pointer

        if (sPointer == length) { // Check if pointer is out ouf bounds
            stackExtender();
        }

        stack[sPointer] = val;

    }

    public int pop() {
        shrinkCheck();
        return stack[sPointer--];
    }
}