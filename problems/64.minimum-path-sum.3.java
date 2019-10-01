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

        int rows[][] = new int[2][columnCnt];
        int currentRow = 0;

        rows[currentRow][0] = grid[0][0];
        for (int j = 1; j < columnCnt; j++) {
            rows[currentRow][j] = grid[0][j] + rows[currentRow][j - 1];
        }
        for (int i = 1; i < rowCnt; i++) {
            currentRow = 1 - currentRow;
            rows[currentRow][0] = grid[i][0] + rows[1 - currentRow][0];
            // System.out.println(Arrays.toString(lastRows));
            // System.out.println(Arrays.toString(rows[currentRow]));
            for (int j = 1; j < columnCnt; j++) {
                rows[currentRow][j] = grid[i][j] + Math.min(rows[1 - currentRow][j], rows[currentRow][j - 1]);
            }
            // System.out.println(Arrays.toString(lastRows));
            // System.out.println(Arrays.toString(rows[currentRow]));
            // System.out.println();
        }
        // for (int i = 0; i < rowCnt; i++) {
        // System.out.println(Arrays.toString(s[i]));
        // }
        grid[0][0] = 100;
        return rows[currentRow][columnCnt - 1];
    }

    public static void main(String[] args) {
    int[][] nums = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    System.out.println(new Solution().minPathSum(nums));
    }
}
