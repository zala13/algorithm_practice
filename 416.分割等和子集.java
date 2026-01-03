/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=30305
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } 
                else if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return dp[n][sum];
    }
}

// true false false false false false false false false false false false  
// ' +
//   'true true false false false false false false false false false false  
// ' +    (2,1) = (1,-4) || (1,1),但是进都进不来，所以必须要有if-else
//   'true false false false false true true false false false false false  
// ' +
//   'true false false false false false false false false false true false  
// ' +
//   'true false false false false false true false false false true false  

// true false false false false false false false false false false false  
// ' +
//   'true true false false false false false false false false false false  
// ' +
//   'true true false false false true true false false false false false  
// ' +
//   'true true false false false true true false false false true true  
// ' +
//   'true true false false false true true true false false true true  

// @lc code=end



/*
// @lcpr case=start
// [1,5,10,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,5]\n
// @lcpr case=end

 */

