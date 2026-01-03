/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30305
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode parent = new TreeNode();
    private boolean flag = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = root;
        backtrack(root, p, q);
        return parent;
    }

    private int backtrack(TreeNode root, TreeNode p, TreeNode q) {
        if (flag || root == null) {
            return 0;
        }
        int curr = (root == q || root == p) ? 1 : 0;
        int left = backtrack(root.left, p, q);
        int right = backtrack(root.right, p, q);
        int end = curr + left + right;
        if (!flag && end >= 2) {
            flag = true;
            parent = root;
        }
        return end;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */

