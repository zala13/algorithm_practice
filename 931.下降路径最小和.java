/*
 * @lc app=leetcode.cn id=931 lang=java
 * @lcpr version=30307
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (j == 0) {
                        dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                    } else if (j == n - 1) {
                        dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]);
                    } else {
                        dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                    }
                }
                if (i == m - 1) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,3],[6,5,4],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[-19,57],[-40,-5]]\n
// @lcpr case=end

 */

