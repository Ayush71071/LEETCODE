class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // 1. Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            // 2. Find the smallest element greater than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;

            swap(nums, i, j);
        }

        // 3. Reverse the suffix
        reverse(nums, i + 1, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }
}