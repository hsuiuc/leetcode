import java.util.ArrayList;
import java.util.List;

/**
 * Created by haosun on 3/23/18.
 */
public class Division {
    public static String divide(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a / b).append(".");
        a = a % b;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (a != 0 && !list1.contains(a)) {
            list1.add(a);
            list2.add(a * 10 / b);
            a = (a * 10) % b;
        }

        if (a == 0) {
            for (int i : list2) {
                sb.append(i);
            }
        } else {
            int repeatStart = list1.indexOf(a);
            for (int i = 0; i < repeatStart; i++) {
                sb.append(list2.get(i));
            }
            sb.append("(");
            for (int i = repeatStart; i < list2.size(); i++) {
                sb.append(list2.get(i));
            }
            sb.append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = Division.divide(2 , 987);
        System.out.println(s);
    }
}
