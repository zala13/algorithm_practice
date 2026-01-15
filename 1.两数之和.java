/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30306
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.Map;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> need = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (need.containsKey(target - num)) {
                return new int[]{i, need.get(target - num)};
            } else {
                need.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [3,3]\n6\n
// @lcpr case=end

 */

