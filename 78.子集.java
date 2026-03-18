/*
 * @lc app=leetcode.cn id=78 lang=java
 * @lcpr version=30305
 *
 * [78] 子集
 */

// @lc code=start

import java.util.List;
import java.util.Set;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        res.add(new LinkedList<>(path));
        Set<Integer> seen = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            seen.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
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
 * // [0]\n
 * // @lcpr case=end
 * 
 */
