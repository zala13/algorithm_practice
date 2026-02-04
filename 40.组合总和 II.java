/*
 * @lc app=leetcode.cn id=40 lang=java
 * @lcpr version=30307
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
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
            res.add(new LinkedList(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
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

