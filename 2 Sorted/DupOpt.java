public class DupOpt {
    public static int search(int[] arr1, int[] arr2) {
        int indx1 = 0;
        int indx2 = 0;

        int dupCounter = 0;

        while (indx1 != arr1.length && indx2 != arr2.length) {

            if (arr2[indx2] == arr1[indx1]) {
                dupCounter++;
                indx1++;
                continue;
            }

            if (arr2[indx2] < arr1[indx1]) {
                indx2++;
            } else if (arr2[indx2] > arr1[indx1]) {
                indx1++;
            }
        }

        return dupCounter;
    }
}
