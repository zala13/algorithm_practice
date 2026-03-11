/*
 * @lc app=leetcode.cn id=191 lang=java
 * @lcpr version=30400
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 11\n
// @lcpr case=end

// @lcpr case=start
// 128\n
// @lcpr case=end

// @lcpr case=start
// 2147483645\n
// @lcpr case=end

 */

