/*
 * @lc app=leetcode.cn id=40 lang=java
 * @lcpr version=30307
 *
 * [40] 组合总和 II
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index) {
        if (sum > target || index > candidates.length) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }

        Set<Integer> seen = new HashSet<>();
        // if (!path.isEmpty()) {
        //     seen.add(path.getLast());
        // }
        for (int i = index; i < candidates.length; i++) {
            if (seen.contains(candidates[i])) {
                continue;
            }
            seen.add(candidates[i]);
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,1,2,7,6,1,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2,5,2,1,2]\n5\n
// @lcpr case=end

 */

