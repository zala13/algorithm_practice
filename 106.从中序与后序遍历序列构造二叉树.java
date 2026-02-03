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
    int post, in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return build(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        TreeNode node = new TreeNode(postorder[post]);
        post--;
        node.right = build(inorder, postorder, node.val);
        node.left = build(inorder, postorder, stop);
        return node;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [9,3,15,20,7]\n[9,15,7,20,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */

