/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30306
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> valueToIndex = new HashMap();
        for (int i = 0; i < n; i++) {
            int num = target - nums[i];
            if (valueToIndex.containsKey(num)) {
                result[0] = i;
                result[1] = valueToIndex.get(num);
                return result;
            }
            valueToIndex.put(nums[i], i);
        }
        return result;
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

