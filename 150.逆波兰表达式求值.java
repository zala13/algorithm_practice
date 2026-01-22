/*
 * @lc app=leetcode.cn id=150 lang=java
 * @lcpr version=30307
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int num1 = stk.pop();
                int num2 = stk.pop();
                stk.push(num1 + num2);
            } else if (str.equals("-")) {
                int num1 = stk.pop();
                int num2 = stk.pop();
                stk.push(num2 - num1);
            } else if (str.equals("*")) {
                int num1 = stk.pop();
                int num2 = stk.pop();
                stk.push(num1 * num2);
            } else if (str.equals("/")) {
                int num1 = stk.pop();
                int num2 = stk.pop();
                int res = num2 / num1;
                System.out.println("*" + res + "*");
                stk.push(num2 / num1);
            } else {
                if (str.charAt(0) == '-') {
                    stk.push(0 - Integer.parseInt(str.substring(1)));
                } else {
                    stk.push(Integer.parseInt(str));
                }
            }
        }
        System.out.println();
        return stk.pop();
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["2","1","+","3","*"]\n
// @lcpr case=end

// @lcpr case=start
// ["4","13","5","/","+"]\n
// @lcpr case=end

// @lcpr case=start
// ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]\n
// @lcpr case=end

 */

