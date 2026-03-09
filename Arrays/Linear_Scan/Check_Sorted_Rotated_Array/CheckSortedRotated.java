package Check_Sorted_Rotated_Array;

import java.util.Scanner;

public class CheckSortedRotated {
    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        } 
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean result = check(nums);
        if (result) {
            System.out.println("Array is sorted and rotated");
        } else {
            System.out.println("Array is NOT sorted and rotated");
        }
        sc.close();
    }
}