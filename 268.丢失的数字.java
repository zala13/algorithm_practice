/*
 * @lc app=leetcode.cn id=268 lang=java
 * @lcpr version=30400
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i <= n; i++) {
            res ^= i;
        }
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [9,6,4,2,3,5,7,0,1]\n
// @lcpr case=end

 */

