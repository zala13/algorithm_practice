/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30305
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.List;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(')');
            } else if (c == '[') {
                stk.push(']');
            } else if (c == '{') {
                stk.push('}');
            } else if (stk.isEmpty() || c != stk.pop()) {
                return false;
            }
        }
        if (stk.isEmpty()) {
            return true;
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

// @lcpr case=start
// "([)]"\n
// @lcpr case=end

 */

