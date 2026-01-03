/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30305
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (left <= right && nums[left] != 0) {
                left++;
                right++;
                continue;
            }
            if (right < n && nums[right] == 0) {
                right++;
                continue;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

