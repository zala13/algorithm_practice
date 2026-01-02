/*
 * @lc app=leetcode.cn id=124 lang=java
 * @lcpr version=30305
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        findOneMaxSum(root);
        return maxSum;
    }

    private int findOneMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxSum = Math.max(0, findOneMaxSum(root.left));
        int rightMaxSum = Math.max(0, findOneMaxSum(root.right));
        int currSum = root.val + leftMaxSum + rightMaxSum;
        maxSum = Math.max(currSum, maxSum);
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [-10,9,20,null,null,15,7]\n
// @lcpr case=end

 */

