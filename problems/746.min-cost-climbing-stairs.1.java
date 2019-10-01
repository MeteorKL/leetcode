import java.util.Arrays;

/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */
class Solution {
    public int minCostClimbingStairs(int[] c) {
        int s[] = new int[c.length];
        s[0] = 0;
        s[1] = Math.min(c[0], c[1]);
        // s[2] = Math.min(s[0] +c[1], s[1] + c[2]);
        // s[3] = Math.min(s[1] + c[2], s[2] + c[3]);
        for (int i = 2; i < c.length; i++) {
            s[i] = Math.min(s[i - 2] + c[i - 1], s[i - 1] + c[i]);
        }
        // System.out.println(Arrays.toString(s));
        return s[c.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(new Solution().minCostClimbingStairs(nums));
    }
}
