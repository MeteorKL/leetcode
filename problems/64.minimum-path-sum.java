import java.util.Arrays;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rowCnt = grid.length;
        int columnCnt = grid[0].length;

        int dp[] = new int[columnCnt];

        dp[0] = grid[0][0];
        for (int j = 1; j < columnCnt; j++) {
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for (int i = 1; i < rowCnt; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < columnCnt; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[columnCnt - 1];
    }

    // public static void main(String[] args) {
    // int[][] nums = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    // System.out.println(new Solution().minPathSum(nums));
    // }
}
