/*
 * @lc app=leetcode.cn id=376 lang=java
 * @lcpr version=30307
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int up = 1;    // 以nums[0]结尾，最后是上升的最长长度
        int down = 1;  // 以nums[0]结尾，最后是下降的最长长度

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                // 当前是上升 -> up = down + 1（之前必须是下降状态）
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                // 当前是下降 -> down = up + 1（之前必须是上升状态）
                down = up + 1;
            }
            // 相等时，up和down保持不变
        }

        return Math.max(up, down);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,7,4,9,2,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,17,5,10,13,15,10,5,16,8]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6,7,8,9]\n
// @lcpr case=end

 */

