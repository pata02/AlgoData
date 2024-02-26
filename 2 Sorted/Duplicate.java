public class Duplicate {
    public static int search(int[] keyArray, int[] array2) {
        int dupCounter = 0;
        
        for (int i = 0; i < keyArray.length; i++) {
            if (Binary.search(array2, keyArray[i])) {
                dupCounter++;
            }
        }
        return dupCounter;
    }
}
