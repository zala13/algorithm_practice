/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30305
 *
 * [128] 最长连续序列
 */

// @lc code=start

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res= 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int curLen = 1;

            while (set.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            res = Math.max(res, curLen);
        }
        return res;
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

