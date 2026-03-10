class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String args[]) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        int k = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}