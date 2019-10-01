import java.util.Arrays;

/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */
class Solution {
    public int minCostClimbingStairs(int[] c) {
        int last_2 = 0;
        int last_1 = Math.min(c[0], c[1]);
        int curr = last_1;
        for (int i = 2; i < c.length; i++) {
            curr = Math.min(last_2 + c[i - 1], last_1 + c[i]);
            last_2 = last_1;
            last_1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(new Solution().minCostClimbingStairs(nums));
    }
}
