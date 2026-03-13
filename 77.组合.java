/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=30307
 *
 * [77] 组合
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    private void backtrack(int n, int index, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = index; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1, k);
            track.remove(track.size() - 1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n2\n
// @lcpr case=end

// @lcpr case=start
// 1\n1\n
// @lcpr case=end

 */

