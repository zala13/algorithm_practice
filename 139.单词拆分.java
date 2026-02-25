/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30305
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    private boolean flag = false;
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, wordDict, 0);
    }

    private boolean dp(String s, List<String> wordDict, int index) {
        if (flag) {
            return true;
        }
        if (!flag && index == s.length()) {
            flag = true;
            return true;
        }
        if (memo[index] == 1) {
            return true;
        } else if (memo[index] == 0) {
            return false;
        }
        for (String word : wordDict) {
            if (index + word.length() > s.length()) {
                continue;
            }
            if (s.substring(index, index + word.length()).equals(word)) {
                memo[index] = dp(s, wordDict, index + word.length()) == true ? 1 : 0;
            }
        }
        return memo[index] == 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "leetcode"\n["leet","code"]\n
// @lcpr case=end

// @lcpr case=start
// "applepenapple"\n["apple","pen"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats","dog","sand","and","cat"]\n
// @lcpr case=end

 */

