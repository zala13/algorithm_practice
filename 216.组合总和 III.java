/*
 * @lc app=leetcode.cn id=216 lang=java
 * @lcpr version=30307
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> track = new LinkedList<>();
    private int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return res;
    }

    private void backtrack(int k, int n, int index) {
        if (sum > n || track.size() > k) {
            return;
        }
        if (sum == n && track.size() == k) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = index; i <= 9; i++) {
            sum += i;
            track.add(i);
            backtrack(k, n, i + 1);
            track.remove(track.size() - 1);
            sum -= i;
        }
    }

}
// @lc code=end



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 3\n9\n
// @lcpr case=end

// @lcpr case=start
// 4\n1\n
// @lcpr case=end

 */

