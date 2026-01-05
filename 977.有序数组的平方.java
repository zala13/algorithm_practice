/*
 * @lc app=leetcode.cn id=977 lang=java
 * @lcpr version=30305
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        int idx = n - 1;
        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (l < r) {
                res[idx] = r;
                right--;
            } else {
                res[idx] = l;
                left++;
            }
            idx--;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-4,-1,0,3,10]\n
// @lcpr case=end

// @lcpr case=start
// [-7,-3,2,3,11]\n
// @lcpr case=end

 */

