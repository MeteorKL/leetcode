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
        int rows = grid.length;
        int columns = grid[0].length;
        int s[][] = new int[rows][columns];
        s[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            s[i][0] = grid[i][0] + s[i - 1][0];
        }
        for (int j = 1; j < columns; j++) {
            s[0][j] = grid[0][j] + s[0][j - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                s[i][j] = grid[i][j] + Math.min(s[i - 1][j], s[i][j - 1]);
            }
        }
        // for (int i = 0; i < rows; i++) {
        // System.out.println(Arrays.toString(s[i]));
        // }
        return s[rows - 1][columns - 1];
    }

    // public static void main(String[] args) {
    // int[][] nums = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    // System.out.println(new Solution().minPathSum(nums));
    // }
}
