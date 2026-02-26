/*
 * @lc app=leetcode.cn id=213 lang=java
 * @lcpr version=30400
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[2][n + 1];
        // 0 代表不拿第一个 1 代表拿第一个
        dp[0][0] = 0; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = nums[0];
        for(int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(
                dp[0][i - 1],
                dp[0][i - 2] + nums[i - 1]
            );
            dp[1][i] = Math.max(
                dp[1][i - 1],
                dp[1][i - 2] + nums[i - 1]
            );
        }
        return dp[0][n] > dp[1][n - 1] ? dp[0][n] : dp[1][n - 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

