import java.util.Arrays;

/**
 * Created by haosun on 3/29/18.
 */
public class Knuth {
    private Knuth() {}

    public static void shuffle(Object[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int index = (int) (Math.random() * (i + 1));
            Object swap = array[index];
            array[index] = array[i];
            array[i] = swap;
        }
    }

    public static void shuffleAlternate(Object[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int index = i + (int) (Math.random() * (n - i));
            Object swap = array[index];
            array[index] = array[i];
            array[i] = swap;
        }
    }

    public static void main(String[] args) {
        int length = 15;
        Integer[] array = new Integer[length];
        for (int i = 1; i <= length; i++) {
            array[i - 1] = i;
        }
        Knuth.shuffle(array);
        System.out.println(Arrays.toString(array));
        Knuth.shuffleAlternate(array);
        System.out.println(Arrays.toString(array));
    }
}
