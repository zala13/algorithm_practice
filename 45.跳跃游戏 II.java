/*
 * @lc app=leetcode.cn id=45 lang=java
 * @lcpr version=30305
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int end = 0;
        int maxPos = nums[0];
        int step = 0;
        for (int i = 0; i <= n - 2; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (end == i) {
                step++;
                end = maxPos;
            }
        }
        return step;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,0,1,4]\n
// @lcpr case=end

 */

