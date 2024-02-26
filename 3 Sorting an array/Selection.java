public class Selection {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int candidate = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[candidate]) {
                    candidate = j;
                }
            }
            //Swaping
            int holder = array[i];
            array[i] = array[candidate];
            array[candidate] = holder;

        }
        
        return;
    }
}
