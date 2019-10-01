import java.util.Arrays;

/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */
class Solution {
    public int minCostClimbingStairs(int[] c) {
        int last_2 = c[0];
        int last_1 = c[1];
        for (int i = 2; i < c.length; i++) {
            int curr = c[i] + Math.min(last_2, last_1);
            last_2 = last_1;
            last_1 = curr;
            // System.out.println(last_1 +","+ last_2);
        }
        return Math.min(last_1, last_2);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(new Solution().minCostClimbingStairs(nums));
    }
}
