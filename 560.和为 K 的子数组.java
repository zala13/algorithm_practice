/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30305
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            count.put(preSum[i], count.getOrDefault(preSum[i], 0) + 1);
            
        }
        return res;
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

