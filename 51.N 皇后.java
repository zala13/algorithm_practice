/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30305
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder path = new StringBuilder();
            for (int j = 0; j < n; j++) {
                path.append('.');
            }
            res.add(new StringBuilder(path));
        }
        backtrack(n, res, 0);
        return ans;
    }

    private void backtrack(int n, List<StringBuilder> res, int row) {
        if (row == n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(res.get(i).toString());
            }
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(n, res, row, i)) {
                continue;
            }
            res.get(row).setCharAt(i, 'Q');
            backtrack(n, res, row + 1);
            res.get(row).setCharAt(i, '.');
        }
    }

    private boolean isValid(int n, List<StringBuilder> res, int row, int col) {
        // 无需行检测

        // 列检测
        for (int x = 0; x < row; x++) {
            if (res.get(x).charAt(col) == 'Q') {
                return false;
            }
        }

        // 对角检测
        for (int i = row, j = col; i >= 0 && j >= 0; i-- , j--) {
            if (res.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (res.get(i).charAt(j) == 'Q') {
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

