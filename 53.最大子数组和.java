/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30305
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while (right < n) {
            sum += nums[right];
            right++;
            max=  Math.max(max, sum);
            while (sum < 0 && left < right) {
                sum -= nums[left];
                left++;
            }
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */

