/*
 * @lc app=leetcode.cn id=541 lang=java
 * @lcpr version=30307
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        int left = 0, right = 0, n = s.length();
        StringBuilder res = new StringBuilder();
        while (n - left >= k) {
            StringBuilder s1 = new StringBuilder(s.substring(left, left + k));
            int start = 0, end = s1.length() - 1;
            while (start < end) {
                char ch = s1.charAt(start);
                s1.setCharAt(start, s1.charAt(end));
                s1.setCharAt(end, ch);
                start++;
                end--;
            }
            res.append(s1);
            res.append(s.substring(left + k, n >= left + 2 * k ? left + 2 * k : n));
            left = n >= left + 2 * k ? left + 2 * k : n;
        }
        if (left < n) {
            StringBuilder s1 = new StringBuilder(s.substring(left, n));
            int start = 0, end = s1.length() - 1;
            while (start < end) {
                char ch = s1.charAt(start);
                s1.setCharAt(start, s1.charAt(end));
                s1.setCharAt(end, ch);
                start++;
                end--;
            }
            res.append(s1);
        }
        return res.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcdefg"\n2\n
// @lcpr case=end

// @lcpr case=start
// "abcd"\n2\n
// @lcpr case=end

 */

