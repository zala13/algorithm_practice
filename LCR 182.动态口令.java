/*
 * @lc app=leetcode.cn id=LCR 182 lang=java
 * @lcpr version=30307
 *
 * [LCR 182] 动态口令
 */

// @lc code=start
class Solution {
    public String dynamicPassword(String password, int target) {
        if (target >= password.length()) {
            return password;
        }
        StringBuilder s = new StringBuilder(password);
        int left = 0, right = target - 1;
        while (left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
        left = target;
        right = s.length() - 1;
        while (left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
        left = 0;
        right = s.length() - 1;
        while (left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
        return s.toString();
    }

}
// @lc code=end



/*
// @lcpr case=start
// "s3cur1tyC0d3"\n4\n
// @lcpr case=end

// @lcpr case=start
// "vbzkgsaoiu"\n2\n
// @lcpr case=end

 */

