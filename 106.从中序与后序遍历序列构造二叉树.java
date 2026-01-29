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
    int post;
    int in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return build(postorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] postorder, int[] inorder, int stop) {
        if (post < 0) return null;

        // 如果中序遍历当前值等于 stop，说明这个子树构建完了，返回 null
        if (inorder[in] == stop) {
            in--;
            return null;
        }

        // 创建当前根节点（后序遍历当前值）
        TreeNode root = new TreeNode(postorder[post--]);

        // 先构建右子树，以当前根节点值为“右子树的 stop”
        root.right = build(postorder, inorder, root.val);

        // 再构建左子树，stop 不变（因为左子树的边界还是原来的 stop）
        root.left = build(postorder, inorder, stop);

        return root;
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

