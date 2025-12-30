/*
 * @lc app=leetcode.cn id=118 lang=java
 * @lcpr version=30305
 *
 * [118] 杨辉三角
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prevRow = res.get(res.size() - 1);
            res.add(generateNextRow(prevRow));
        }
        return res;
    }

    private List<Integer> generateNextRow(List<Integer> prevRow) {
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            newRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        newRow.add(1);
        return newRow;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 5\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

