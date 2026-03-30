/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30305
 *
 * [54] 螺旋矩阵
 */

// @lc code=start

import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        List<Integer> res = new LinkedList<>();
        while (up <= down && left <= right) {
            for (int j = left; j <= right && up <= down; j++) {
                res.add(matrix[up][j]);
            }
            up++;
            for (int i = up; i <= down && left <= right; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int j = right; j >= left && up <= down; j--) {
                res.add(matrix[down][j]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
// @lcpr case=end

 */

