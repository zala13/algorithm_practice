/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30305
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    flood(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void flood(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }
        flood(grid, i + 1, j);
        flood(grid, i - 1, j);
        flood(grid, i, j + 1);
        flood(grid, i, j - 1);
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]\n
// @lcpr case=end

 */

