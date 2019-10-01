/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    // public static void main(String[] args) {
    // int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    // System.out.println(new Solution().maxSubArray(nums));
    // }
}
