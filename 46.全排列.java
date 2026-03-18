/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30305
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.List;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, i);
            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n
 * // @lcpr case=end
 * 
 */
