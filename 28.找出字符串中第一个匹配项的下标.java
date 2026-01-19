/*
 * @lc app=leetcode.cn id=28 lang=java
 * @lcpr version=30305
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String txt, String pat) {
        int N = txt.length(), L = pat.length();

        for (int i = 0; i + L <= N; i++) {
            String subStr = txt.substring(i, i + L);
            if (subStr.equals(pat)){
                // 在 txt 中找到模式串 pat，返回起始索引
                return i;
            }
        }
        // txt 中不存在模式串 pat
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "sadbutsad"\n"sad"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n"leeto"\n
// @lcpr case=end

 */

