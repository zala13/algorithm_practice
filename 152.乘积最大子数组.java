/*
 * @lc app=leetcode.cn id=152 lang=java
 * @lcpr version=30305
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]));
            res = Math.max(dpMax[i], res);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,-2,4]\n
// @lcpr case=end

// @lcpr case=start
// [-2,0,-1]\n
// @lcpr case=end

 */

