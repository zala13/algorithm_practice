/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30305
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> res = new LinkedList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums, 0);
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

