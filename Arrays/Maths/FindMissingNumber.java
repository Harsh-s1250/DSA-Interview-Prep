public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        int missingNumber = sum - actualSum;
        System.out.println("The missing number is: " + missingNumber);
    }
}
