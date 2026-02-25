/*
 * @lc app=leetcode.cn id=518 lang=java
 * @lcpr version=30400
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - coins[j - 1] >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[amount][n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n[1,2,5]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[2]\n
// @lcpr case=end

// @lcpr case=start
// 10\n[10]\n
// @lcpr case=end

 */

