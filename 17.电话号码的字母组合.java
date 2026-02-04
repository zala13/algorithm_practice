/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30305
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] key = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new LinkedList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length() && path.length() == digits.length()) {
            res.add(new String(path.toString()));
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            String choices = key[digits.charAt(i) - '0'];
            for (int j = 0; j < choices.length(); j++) {
                path.append(choices.charAt(j));
                backtrack(digits, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

