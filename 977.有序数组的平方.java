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
        int[] res = new int[n];
        int i = 1;
        for (; i < n; i++) {
            if (nums[i] >= 0 && nums[i - 1] < 0) {
                break;
            }
        }
        int left = i - 1, right = i;
        int idx = 0;
        while (left >= 0 && right < n) {
            int r = nums[right] * nums[right];
            int l = nums[left] * nums[left];
            if (l > r) {
                res[idx] = r;
                right++;                
            } else {
                res[idx] = l;
                left--;
            }
            idx++;
        }
        while (left-- >= 0) {
            res[idx] = nums[left] * nums[left];
            idx++;
        }
        while (right++ < n) {
            res[idx] = nums[right] * nums[right];
            idx++;
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

