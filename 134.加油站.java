/*
 * @lc app=leetcode.cn id=134 lang=java
 * @lcpr version=30400
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int minSum = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if(sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }
        return sum >= 0 ? start % (n) : -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n[3,4,5,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,4]\n[3,4,3]\n
// @lcpr case=end

 */

