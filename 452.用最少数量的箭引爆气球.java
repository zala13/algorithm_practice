/*
 * @lc app=leetcode.cn id=452 lang=java
 * @lcpr version=30400
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<>() {
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) {
                    return 1;
                } else if (a[1] == b[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[10,16],[2,8],[1,6],[7,12]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[3,4],[5,6],[7,8]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[2,3],[3,4],[4,5]]\n
// @lcpr case=end

 */

