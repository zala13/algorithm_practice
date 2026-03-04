/*
 * @lc app=leetcode.cn id=55 lang=java
 * @lcpr version=30305
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i <= (max > n ? n : max); i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1,0,4]\n
// @lcpr case=end

 */

