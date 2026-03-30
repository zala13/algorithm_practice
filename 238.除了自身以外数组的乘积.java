/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30305
 *
 * [238] 除了自身以外数组的乘积
 */

// @lc code=start
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        int[] post = new int[n];
        post[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int res = 1;
            System.out.print(i + " ");
            res *= i - 1 >= 0 ? pre[i - 1] : 1;
            System.out.print(res + " ");
            res *= i + 1 <= n - 1 ? post[i + 1] : 1;
            System.out.println(res + " ");
            result[i] = res;
        }
        return result;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */
