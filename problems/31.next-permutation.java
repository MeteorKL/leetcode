import java.util.Arrays;

/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            System.out.println(nums);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j] && nums[j] < min) {
                        min = nums[j];
                        minIndex = j;
                    }
                }
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1 };
        new Solution().nextPermutation(nums);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[0]));
        for (int j = 1; j < nums.length; j++) {
            sb.append(",").append(String.valueOf(nums[j]));
        }
        System.out.println(sb.toString());
    }
}
