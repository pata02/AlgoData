public class OldDup {
    public static int search(int[] arr1, int[] arr2) {
        int dupCounter = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            if (Linear.search(arr2, arr1[i])) {
                dupCounter++;
            }
        }
        return dupCounter;
    }
}
