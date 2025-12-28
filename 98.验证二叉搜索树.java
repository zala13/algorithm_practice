/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30305
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, root, null) 
                && isValid(root.right, null, root);
    }
    private boolean isValid(TreeNode root, TreeNode maxNode, TreeNode minNode) {
        if (root == null) {
            return true;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            return false;
        }
        if (minNode != null && root.val <= minNode.val) {
            return false;
        }
        boolean isLeft = isValid(root.left, root, minNode);
        boolean isRight = isValid(root.right, maxNode, root);

        return isLeft && isRight;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,6,null,null,3,7]\n
// @lcpr case=end

 */

