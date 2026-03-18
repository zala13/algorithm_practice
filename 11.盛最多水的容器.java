/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30304
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            int curArea = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(curArea, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

 */
