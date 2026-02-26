/*
 * @lc app=leetcode.cn id=174 lang=java
 * @lcpr version=30400
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    private int[][] memo;
    private final int[][] directions = {
        {1, 0},
        {0, 1}
    };
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
        backtrack(dungeon, 0, 0);
        return memo[0][0];
    }

    private int backtrack(int[][] dungeon, int row, int col) {
        int m = dungeon.length, n = dungeon[0].length;
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        for (int[] dirc : directions) {
            int i = row + dirc[0];
            int j = col + dirc[1];
            if (i < 0 || i >= m || j < 0 || j >= n) {
                continue;
            }
            int next = -dungeon[row][col] + backtrack(dungeon, i, j);
            int res = Math.min(memo[row][col], next);
            res = res <= 0 ? 1 : res;
            memo[row][col] = res;
        }
        return memo[row][col];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[-2,-3,3],[-5,-10,1],[10,30,-5]]\n
// @lcpr case=end

// @lcpr case=start
// [[0]]\n
// @lcpr case=end

 */

