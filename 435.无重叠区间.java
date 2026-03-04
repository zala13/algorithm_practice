/*
 * @lc app=leetcode.cn id=435 lang=java
 * @lcpr version=30400
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    private int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2],[2,3],[3,4],[1,3]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[1,2],[1,2]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[2,3]]\n
// @lcpr case=end

 */

