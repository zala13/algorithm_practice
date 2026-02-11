/*
 * @lc app=leetcode.cn id=491 lang=java
 * @lcpr version=30307
 *
 * [491] 非递减子序列
 */

// @lc code=start

import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int index) {
        if (path.size() >= 2) {
            res.add(new LinkedList(path));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) ||
                used.contains(nums[i])) {
                    continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,6,7,7,7]\n
// @lcpr case=end

// @lcpr case=start
// [4,4,3,2,1]\n
// @lcpr case=end

 */

