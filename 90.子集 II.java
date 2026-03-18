/*
 * @lc app=leetcode.cn id=90 lang=java
 * @lcpr version=30307
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
 * // [1,2,2]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0]\n
 * // @lcpr case=end
 * 
 */
