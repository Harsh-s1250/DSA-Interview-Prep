import java.util.ArrayList;
import java.util.List;

public class Union {

    public static void main(String args[]) {
        int[] arr1 = { 1, 2, 2, 3, 5 };
        int[] arr2 = { 2, 3, 4, 5, 6 };
        List<Integer> result = findUnion(arr1, arr2);
        System.out.println(result);
    }

    public static List<Integer> findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        List<Integer> union = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } else {
                union.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            union.add(arr1[i]);
            i++;
        }
        while (j < arr2.length) {
            union.add(arr2[j]);
            j++;
        }
        return union;
    }
}
