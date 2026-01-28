/*
 * @lc app=leetcode.cn id=112 lang=java
 * @lcpr version=30307
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }

    private boolean hasPath(TreeNode root, int targetSum, int currSum) {        
        if (root == null) {
            return false;
        }
        currSum += root.val;
        System.out.println(currSum);
        if (root.left == null && root.right == null && targetSum == currSum) {
            return true;
        }
        return hasPath(root.left, targetSum, currSum) || hasPath(root.right, targetSum, currSum);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,null,1]\n22\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

