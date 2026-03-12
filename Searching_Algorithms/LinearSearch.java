public class LinearSearch {

    static boolean Linearsearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int target = 3;
        boolean result = Linearsearch(arr, target);
        if (result) {
            System.out.println("Element found in the array.");
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
