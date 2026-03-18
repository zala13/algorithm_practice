/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30305
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }

    int pre = 0, in = 0;

    private TreeNode helper(int[] preorder, int[] inorder, int stop_val) {
        if (pre >= preorder.length) {
            return null;
        }
        if (stop_val == inorder[in]) {
            in++;
            return null;
        }
        int root_val = preorder[pre];
        pre++;
        TreeNode node = new TreeNode(root_val);
        node.left = helper(preorder, inorder, root_val);
        node.right = helper(preorder, inorder, stop_val);
        return node;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,9,20,15,7]\n[9,3,15,20,7]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-1]\n[-1]\n
 * // @lcpr case=end
 * 
 */
