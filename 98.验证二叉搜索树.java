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
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, TreeNode max, TreeNode min) {
        if (node == null) {
            return true;
        }
        if (max != null && node.val >= max.val) {
            return false;
        }
        if (min != null && node.val <= min.val) {
            return false;
        }
        return helper(node.left, node, min) && helper(node.right, max, node);
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

