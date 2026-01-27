/*
 * @lc app=leetcode.cn id=110 lang=java
 * @lcpr version=30307
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        backtrack(root);
        return isBalanced;
    }
    boolean isBalanced = true;
    public int backtrack(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = backtrack(node.left);
        int right = backtrack(node.right);
        if (Math.abs(right - left) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,3,3,null,null,4,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

