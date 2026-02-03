/*
 * @lc app=leetcode.cn id=669 lang=java
 * @lcpr version=30307
 *
 * [669] 修剪二叉搜索树
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            root.left = null;
            TreeNode node = trimBST(root.right, low, high);
            while (node != null && node.right != null && node.val < low) {
                node = node.right;
            }
            return node;
        } else if (root.val > high) {
            root.right = null;
            TreeNode node = trimBST(root.left, low, high);
            while (node != null && node.left != null && node.val > high) {
                node = node.left;
            }
            return node;
        } else {
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
        }
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,2]\n1\n2\n
// @lcpr case=end

// @lcpr case=start
// [3,0,4,null,2,null,null,1]\n1\n3\n
// @lcpr case=end

 */

