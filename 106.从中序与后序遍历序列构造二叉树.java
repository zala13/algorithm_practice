/*
 * @lc app=leetcode.cn id=106 lang=java
 * @lcpr version=30307
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return helper(inorder, postorder, Integer.MAX_VALUE);
    }

    int in, post;

    private TreeNode helper(int[] inorder, int[] postorder, int stop_val) {
        if (post < 0) {
            return null;
        }
        if (stop_val == inorder[in]) {
            in--;
            return null;
        }
        int root_val = postorder[post];
        post--;
        TreeNode node = new TreeNode(root_val);
        node.right = helper(inorder, postorder, root_val);
        node.left = helper(inorder, postorder, stop_val);
        return node;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [9,3,15,20,7]\n[9,15,7,20,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
