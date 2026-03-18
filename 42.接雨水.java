/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30305
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int sum = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                sum += maxLeft - height[left];
                left++;
            } else {
                sum += maxRight - height[right];
                right--;
            }
        }
        return sum;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */
