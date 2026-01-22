/*
 * @lc app=leetcode.cn id=1047 lang=java
 * @lcpr version=30307
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stk.isEmpty() && ch == stk.peek()) {
                stk.pop();
            } else {
                stk.push(ch);
            }
        }
        StringBuilder res = new StringBuilder(stk.size());
        if (stk.isEmpty()) {
            return new String();
        }
        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }
        return res.reverse().toString();
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abbaca"\n
// @lcpr case=end

// @lcpr case=start
// "azxxzy"\n
// @lcpr case=end

 */

