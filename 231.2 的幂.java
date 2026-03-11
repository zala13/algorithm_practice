/*
 * @lc app=leetcode.cn id=231 lang=java
 * @lcpr version=30400
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0 ? true : false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 16\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

 */

