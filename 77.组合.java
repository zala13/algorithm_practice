/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=30307
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        trackback(n, k, 1);
        return res;
    }

    private void trackback(int n, int k, int index) {
        if (track.size() == k) {
            System.out.println(track);
            res.add(new LinkedList(track));
            return;
        }
        for (int i = index; i <= n; i++) {
            track.add(i);
            trackback(n, k, i + 1);
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

