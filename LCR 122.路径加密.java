/*
 * @lc app=leetcode.cn id=LCR 122 lang=java
 * @lcpr version=30307
 *
 * [LCR 122] 路径加密
 */

// @lc code=start
class Solution {
    public String pathEncryption(String path) {
        StringBuilder s = new StringBuilder(path);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                s.setCharAt(i, ' ');
            }
        }
        return s.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "a.aef.qerf.bb"\n
// @lcpr case=end

 */

