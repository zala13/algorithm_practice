/*
 * @lc app=leetcode.cn id=52 lang=java
 * @lcpr version=30400
 *
 * [52] N 皇后 II
 */

// @lc code=start
class Solution {
    // private List<List<String>> res = new LinkedList<>();
    private int res = 0;
    private char[][] board; 
    public int totalNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int x) {
        if (x == n) {
            // 塞数据
            // List<String> path = new LinkedList<>();
            // for (char[] row : board) {
            //     path.add(new String(row));
            // }
            // res.add(new LinkedList<>(path));
            res++;
        }

        for (int i = 0; i < n; i++) {        
            if (!isValid(n, x, i)) {
                continue;
            }
            board[x][i] = 'Q';
            backtrack(n, x + 1);
            board[x][i] = '.';
        }
    }

    private boolean isValid(int n, int x, int y) {
        // 行 无需验证
        
        // 列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }

        // 斜线
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = x, j = y; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

