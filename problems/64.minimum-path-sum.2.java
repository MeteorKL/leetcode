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

        int lastRows[] = new int[columnCnt];
        int currentRows[] = new int[columnCnt];

        currentRows[0] = grid[0][0];
        for (int j = 1; j < columnCnt; j++) {
            currentRows[j] = grid[0][j] + currentRows[j - 1];
        }
        for (int i = 1; i < rowCnt; i++) {
            int temp[] = lastRows;
            lastRows = currentRows;
            currentRows = temp;
            currentRows[0] = grid[i][0] + lastRows[0];
            // System.out.println(Arrays.toString(lastRows));
            // System.out.println(Arrays.toString(currentRows));
            for (int j = 1; j < columnCnt; j++) {
                currentRows[j] = grid[i][j] + Math.min(lastRows[j], currentRows[j - 1]);
            }
            // System.out.println(Arrays.toString(lastRows));
            // System.out.println(Arrays.toString(currentRows));
            // System.out.println();
        }
        // for (int i = 0; i < rowCnt; i++) {
        // System.out.println(Arrays.toString(s[i]));
        // }
        return currentRows[columnCnt - 1];
    }

    public static void main(String[] args) {
    int[][] nums = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
    System.out.println(new Solution().minPathSum(nums));
    }
}
