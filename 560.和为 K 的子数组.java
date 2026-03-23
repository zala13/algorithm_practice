/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30305
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0;
        Map<Integer, Integer> preSumToTimes = new HashMap<>();
        preSumToTimes.put(0, 1);
        int count = 0;
        for (int num : nums) {
            preSum += num;
            int target = preSum - k;
            if (preSumToTimes.containsKey(target)) {
                count += preSumToTimes.get(target);
            }
            preSumToTimes.put(preSum, preSumToTimes.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n3\n
// @lcpr case=end

 */

