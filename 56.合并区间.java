/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30305
 *
 * [56] 合并区间
 */
// @lc code=start
class Solution {

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int[] interval : intervals) {
            pq.offer(interval);
        }
        List<int[]> nums = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int[] next = pq.poll();
            if (next != null && curr[1] >= next[0]) {
                pq.offer(new int[]{
                    Math.min(curr[0], next[0]),
                    Math.max(curr[1], next[1])
                });
            } else {
                nums.add(curr);
                if (next != null) {
                    pq.offer(next);
                }
            }
        }

        return nums.toArray(new int[nums.size()][]);
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[4,7],[1,4]]\n
// @lcpr case=end

 */
