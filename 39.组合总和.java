/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30305
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index) {
        if (index > candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

