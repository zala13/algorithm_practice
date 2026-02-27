/*
 * @lc app=leetcode.cn id=123 lang=java
 * @lcpr version=30400
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (2 > n / 2) {
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i - 1];
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            }
            return dp[n][0];
        } else {
            int[][][] dp = new int[n + 1][2 + 1][2];
            for (int i = 0; i <= n; i++) {
                dp[i][0][0] = 0;
                dp[i][0][1] = Integer.MIN_VALUE;
            }
            for (int i = 1; i <= n; i++) {
                for (int k = 2; k >= 1; k--) {
                    if (i == 1) {
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i - 1];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
                }
            }
            return dp[n][2][0];
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,3,5,0,0,3,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */

