/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30305
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    private boolean flag = false;
    private boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        visited = new boolean[s.length()];
        backtrack(s, 0, wordDict);
        return flag;
    }

    private void backtrack(String s, int idx, List<String> wordDict) {
        if (idx == s.length()) {
            flag = true;
            return;
        }
        if (flag) {
            return;
        }
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (String word : wordDict) {
            int len = word.length();
            if (idx + len <= s.length() && s.substring(idx, idx + len).equals(word)) {
                
                backtrack(s, idx + len, wordDict);
            }
        }
        
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

