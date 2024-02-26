public class Binary {

    public static boolean search(int[] array, int key) {
        int last = array.length - 1;
        int first = 0;

        while (true) {
            int index = first + ((last - first) / 2);

        
            if (array[index] == key) {
                return true;
            }

            if (last - first == 1) {
                return false;
            }

            if (array[index] < key && index < last) {
                first = index;
                continue;
            }

            if (array[index] > key && index > first) {
                last = index;
                continue;
            }

            return false;
        }
    }
}
