public class LinearOpt {
    public static boolean search(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }

            if (array[index] > key) {
                return false;
            }
            
        }
        return false;
    }
}
