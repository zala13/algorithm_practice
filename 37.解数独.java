/*
 * @lc app=leetcode.cn id=37 lang=java
 * @lcpr version=30307
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    private boolean find = false;
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private void backtrack(char[][] board, int index) {
        int x = index / 9;
        int y = index % 9;
        if (x == 9 && y == 0) {
            find = true;
            return;
        }
        if (x > 8 || y > 8 || find) {
            return;
        }
        if (board[x][y] != '.') {
            backtrack(board, index + 1);
        } else {
            for (char k = '1'; k <= '9'; k++) {
                if (find || !isValid(board, x, y, k)) {
                    continue;
                }
                board[x][y] = k;
                backtrack(board, index + 1);
                if (find) {
                    continue;
                }
                board[x][y] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y, char num) {
        // 行
        for (int j = 0; j < 9; j++) {
            if (board[x][j] == num) {
                return false;
            }
        }

        // 列
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) {
                return false;
            }
        }

        // 3*3
        int up = x, down = x;
        int left = y, right = y;
        while (left % 3 != 0) {
            left--;
        }
        while ((right + 1) % 3 != 0) {
            right++;
        }
        while (up % 3 != 0) {
            up--;
        }
        while ((down + 1) % 3 != 0) {
            down++;
        }
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

 */

