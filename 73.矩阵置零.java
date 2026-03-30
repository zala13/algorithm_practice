/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30305
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (used[i][j]) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < m; x++) {
                        if (matrix[x][j] == 0) {
                            continue;
                        }
                        matrix[x][j] = 0;
                        used[x][j] = true;
                    }
                    for (int y = 0; y < n; y++) {
                        if (matrix[i][y] == 0) {
                            continue;
                        }
                        matrix[i][y] = 0;
                        used[i][y] = true;
                    }
                }
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,1,1],[1,0,1],[1,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
// @lcpr case=end

 */

