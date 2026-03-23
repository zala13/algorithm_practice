/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30305
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int currLength = 1;
            int start = num;
            while (set.contains(start + 1)) {
                start++;
                currLength++;
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,2]\n
// @lcpr case=end

 */

