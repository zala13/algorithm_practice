/*
 * @lc app=leetcode.cn id=209 lang=java
 * @lcpr version=30305
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, n = nums.length;
        int currSum = 0, minLength = n + 1;
        while (right < n) {
            int r = nums[right];
            right++;

            currSum += r;
            int currLength = 0;
            while (left < right && currSum >= target) {
                currLength = right - left;
                minLength = Math.min(currLength, minLength);
                currSum -= nums[left];
                left++;
            }
            System.out.println(left + " " + right);
        }
        return minLength == n + 1 ? 0 : minLength;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 7\n[2,3,1,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[1,4,4]\n
// @lcpr case=end

// @lcpr case=start
// 11\n[1,1,1,1,1,1,1,1]\n
// @lcpr case=end

 */

