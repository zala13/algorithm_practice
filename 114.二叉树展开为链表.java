
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30305
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right, left = root.left;
        flatten(left);
        flatten(right);
        root.right = left;
        root.left = null;
        TreeNode node = root;
        while (node != null && node.right != null) {
            node = node.right;
        }
        node.right = right;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// [1, null, 2, 3]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

