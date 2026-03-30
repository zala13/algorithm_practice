/*
 * @lc app=leetcode.cn id=543 lang=java
 * @lcpr version=30305
 *
 * [543] 二叉树的直径
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
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxLen;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLen = helper(node.left);
        int rightLen = helper(node.right);
        maxLen = Math.max(maxLen, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

