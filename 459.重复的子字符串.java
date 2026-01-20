/*
 * @lc app=leetcode.cn id=459 lang=java
 * @lcpr version=30307
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
        // int n = s.length();
        // for (int i = 0; i < n - i - 1; i++) {
        //     StringBuilder left = new StringBuilder(s.substring(0, i + 1));
        //     StringBuilder right = new StringBuilder(s.substring(i + 1, 2 * (i + 1)));
            
        //     System.out.println("1 " + left + " " + right);
        //     if (left.toString().equals(right.toString()) && n % (i + 1) == 0) {
        //         System.out.println("2 " + left + " " + right);
        //         int index = i + 1;
        //         while (index + i + 1 <= n) {
        //             StringBuilder window = new StringBuilder(s.substring(index, index + i + 1));
        //             if (!left.toString().equals(window.toString())) {
        //                 break;
        //             }
        //             index = index + i + 1;
        //             if (index == n) {
        //                 return true;
        //             }
        //         }
        //     }
        // }
        // return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abab"\n
// @lcpr case=end

// @lcpr case=start
// "aba"\n
// @lcpr case=end

// @lcpr case=start
// "abcabcabcabc"\n
// @lcpr case=end

 */

