public class Insert {
    private static void swap(int[] arr, int indx1, int indx2) {
        int holder = 0;
        holder = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = holder;
        // System.out.println("Swapping");
    }

    public static void sort(int[] array) {
        // System.out.println("Inside insertion sort");

        for (int i = 0; i < array.length; i++) {

            // System.out.println("i:" + i);
            for (int j = i; j > 0 && array[j] > array[j - 1]; j--) {
                // System.out.println("j:" + j);
                swap(array, j, (j - 1));
            }
        }

    }
}
