/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30305
 *
 * [238] 除了自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n + 1];
        preProduct[0] = 1;
        int[] postProduct = new int[n + 1];
        postProduct[n] = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            preProduct[i + 1] = preProduct[i] * nums[i];
            postProduct[n - i - 1] = postProduct[n - i] * nums[n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = preProduct[i] * postProduct[i + 1];
        }
        return res;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */

