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

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    private int helper(TreeNode node, TreeNode p, TreeNode q) {
        if (res != null) {
            return 0;
        }
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, p, q);
        int right = helper(node.right, p, q);
        int sum = left + right;
        if (node.val == p.val || node.val == q.val) {
            sum++;
        }
        if (sum == 2) {
            res = node;
            return 0;
        }
        return sum;
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
