/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=30305
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0, n = nums.length;
        List<Integer> min = new LinkedList<>();
        min.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int sz = min.size();
            for (int j = 0; j < sz; j++) {
                if (j == min.size() - 1 && min.get(j) < num) {
                    min.add(num);
                    break;
                }
                if (num <= min.get(j)) {
                    min.set(j, num);
                    break;
                }
            }
        }
        for (int num : min) {
            System.out.print(num + " ");
        }
        return min.size();
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,9,2,5,3,7,101,18]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,0,3,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7,7,7,7]\n
// @lcpr case=end

 */

