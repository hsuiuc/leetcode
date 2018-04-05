/**
 * Created by haosun on 4/5/18.
 */
public class QuickSort {
    private QuickSort() {}

    public static void sort(Comparable[] array) {
        if (array == null || array.length == 0) return;
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(array, lo, hi);
        sort(array, 0, j - 1);
        sort(array, j + 1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        Comparable pivot = array[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (smallerThan(array[++i], pivot)) {
                if (i == hi) break;
            }

            while (smallerThan(pivot, array[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;

            swap(array, i, j);
        }

        swap(array, lo, j);
        return j;
    }

    private static boolean smallerThan(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
