/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30305
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 转化为背包问题
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[target + 1][n + 1];
        for (int i = 0; i <= target; i++) {
            dp[i][0] = false;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - nums[j - 1] >= 0) {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[target][n];
    }
}

// @lc code=end



/*
// @lcpr case=start
// [1,5,10,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,5]\n
// @lcpr case=end

 */

