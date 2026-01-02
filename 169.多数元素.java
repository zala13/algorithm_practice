/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30305
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (res == 0) {
                target = nums[i];
                res++;
            } else if (res > 0) {
                if (target != nums[i]) {
                    res--;
                } else {
                    res++;
                }
            }
        }
        return target;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,1,1,1,2,2]\n
// @lcpr case=end

 */

