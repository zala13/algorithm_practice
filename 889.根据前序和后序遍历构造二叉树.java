/*
 * @lc app=leetcode.cn id=889 lang=java
 * @lcpr version=30400
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    int post = 0, pre = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder);
    }

    private TreeNode helper(int[] preorder, int[] postorder) {
        if (pre > preorder.length || post > postorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre]);
        pre++;
        if (node.val != postorder[post]) {
            node.left = helper(preorder, postorder);
        }
        if (node.val != postorder[post]) {
            node.right = helper(preorder, postorder);
        }
        post++;
        return node;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1]\n[1]\n
 * // @lcpr case=end
 * 
 */
