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
        if (find) {
            return;
        }
        int row = index / 9;
        int col = index % 9;
        if (!find && index == 81) {
            find = true;
            return;
        }
        if (board[row][col] != '.') {
            backtrack(board, index + 1);
            return;
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!isValid(board, index, ch)) {
                    continue;
                }
                board[row][col] = ch;
                backtrack(board, index + 1);
                if (find) return;
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int index, char ch) {
        int row = index / 9;
        int col = index % 9;
        // row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch && i != col) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch && i != row) {
                return false;
            }
        }

        // part
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == ch && (i != row || j != col)) {
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

