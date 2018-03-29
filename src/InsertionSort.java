import java.util.Arrays;

/**
 * Created by haosun on 3/29/18.
 */
public class InsertionSort {
    private InsertionSort() {}

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && smallerThan(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static void sortOptimized(Comparable[] array) {
        int exchanged = 0;
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            if (smallerThan(array[i], array[i - 1])) {
                swap(array, i, i - 1);
                exchanged++;
            }
        }
        if (exchanged == 0)
            return;

        for (int i = 2; i < n; i++) {
            Comparable v = array[i];
            int j = i;
            while (smallerThan(v, array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
        }
    }

    private static boolean smallerThan(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }

    private static void swap(Comparable[] array, int j, int i) {
        Comparable temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void sort(Comparable[] array, int lo, int hi) {
        int n = array.length;
        assert (lo >= 0 && lo < n);
        assert (hi >= 0 && hi < n);
        assert (hi >= lo);

        for (int i = lo; i < n; i++) {
            for (int j = i; j > lo && smallerThan(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 50;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n);
        }
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
