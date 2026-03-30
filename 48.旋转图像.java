/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30305
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            int up = 0, down = n - 1;
            while (up < down) {
                int temp = matrix[up][j];
                matrix[up][j] = matrix[down][j];
                matrix[down][j] = temp;
                up++;
                down--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2,3],[4,5,6],[7,8,9]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
 * // @lcpr case=end
 * 
 */
