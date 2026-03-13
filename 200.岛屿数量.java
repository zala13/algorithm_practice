/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30305
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flood(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void flood(int[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length) {
            return;
        }
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

