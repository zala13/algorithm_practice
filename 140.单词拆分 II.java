/*
 * @lc app=leetcode.cn id=140 lang=java
 * @lcpr version=30400
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    private int[] memo;
    List<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList();
    public List<String> wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        backtrack(s, wordDict, 0);
        return res;
    }

    private int backtrack(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return 1;
        }
        if (memo[index] == 0) {
            return 0;
        }
        for (String word : wordDict) {
            int length = word.length();
            if (index + length <= s.length() && 
                    s.substring(index, index + length).equals(word)) {
                path.add(word);
                memo[index] = backtrack(s, wordDict, index + length);
                path.removeLast();
            }
        }
        return memo[index];
    }
}
// @lc code=end



/*
// @lcpr case=start
// "catsanddog"\n["cat","cats","and","sand","dog"]\n
// @lcpr case=end

// @lcpr case=start
// "pineapplepenapple"\n["apple","pen","applepen","pine","pineapple"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats","dog","sand","and","cat"]\n
// @lcpr case=end

 */

