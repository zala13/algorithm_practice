/*
 * @lc app=leetcode.cn id=494 lang=java
 * @lcpr version=30400
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }
        int cap = (sum - target) / 2;
        int n = nums.length;
        int[][] dp = new int[cap + 1][n + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= n; j++) {
            // dp[0][j] = 1;
            dp[0][j] = nums[j - 1] == 0 ? dp[0][j - 1] * 2 : dp[0][j - 1];
        }
        for (int i = 1; i <= cap; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - nums[j - 1] >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - nums[j - 1]][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[cap][n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,1,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

