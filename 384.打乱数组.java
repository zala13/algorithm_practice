/*
 * @lc app=leetcode.cn id=384 lang=java
 * @lcpr version=30400
 *
 * [384] 打乱数组
 */

// @lc code=start

import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            int temp = copy[i];
            copy[i] = copy[r];
            copy[r] = temp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end



/*
// @lcpr case=start
// ["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]\n
// @lcpr case=end

 */

