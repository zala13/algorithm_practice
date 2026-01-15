/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30306
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> tracks = twoSum(nums, i + 1, -num);
            if (tracks != null) {
                for (LinkedList<Integer> track : tracks) {
                    track.add(i);
                    res.add(new LinkedList<Integer>(track));
                }
            }
        }
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int index, int target) {
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,0,1,2,-1,-4]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n
// @lcpr case=end

 */

