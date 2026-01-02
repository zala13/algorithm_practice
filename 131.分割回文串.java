/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30305
 *
 * [131] 分割回文串
 */

// @lc code=start

class Solution {
    List<List<String>> res = new LinkedList<>();
    List<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int idx) {
        if (idx == s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (idx > s.length()) {
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i+1);
            if (isPart(s, idx, i)) {
                path.add(str);
                backtrack(s, i + 1);
                path.removeLast();
            }
        }
    }

    private boolean isPart(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n
// @lcpr case=end

 */

