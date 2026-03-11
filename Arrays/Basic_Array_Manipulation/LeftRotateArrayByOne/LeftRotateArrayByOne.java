package Arrays.Basic_Array_Manipulation.LeftRotateArrayByOne;

class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }
}

class Main {
    public static void main(String[] args) {
        LeftRotateArrayByOne solution = new LeftRotateArrayByOne();
        int[] nums = { 1, 2, 3, 4, 5 };

        solution.rotateArrayByOne(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}