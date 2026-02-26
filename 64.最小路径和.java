/*
 * @lc app=leetcode.cn id=64 lang=java
 * @lcpr version=30305
 *
 * [64] 最小路径和
 */

// @lc code=start

class Solution {
    private int[][] memo;
    private final int[][] directions = {
        {1, 0},
        {0, 1}
    };
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[m - 1][n - 1] = grid[m - 1][n - 1];
        backtrack(grid, 0, 0);
        return memo[0][0];
    }

    private int backtrack(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        for (int[] direction : directions) {
            int i = row + direction[0];
            int j = col + direction[1];
            if (i < 0 || i >= m || j < 0 || j >= n) {
                continue;
            }
            memo[row][col] = Math.min(memo[row][col], grid[row][col] + backtrack(grid, i, j));
        }
        return memo[row][col];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,3,1],[1,5,1],[4,2,1]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6]]\n
 * // @lcpr case=end
 * 
 */
