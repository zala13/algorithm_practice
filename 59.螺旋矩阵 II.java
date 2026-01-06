/*
 * @lc app=leetcode.cn id=59 lang=java
 * @lcpr version=30305
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res[up][i] = count;
                count++;
            }
            up++;

            for (int j = up; j <= down; j++) {
                res[j][right] = count;
                count++;
            }
            right--;

            for (int x = right; x >= left; x--) {
                res[down][x] = count;
                count++;
            }
            down--;

            for (int y = down; y >= up; y--) {
                res[y][left] = count;
                count++;
            }
            left++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

