import java.util.Scanner;

class MaxElement {
    int findMaxElement(int arr[]) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = new MaxElement().findMaxElement(arr);
        System.out.println("Maximum element is: " + res);
        sc.close();
    }
}