/*
 * @lc app=leetcode.cn id=530 lang=java
 * @lcpr version=30307
 *
 * [530] 二叉搜索树的最小绝对差
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
    private int min = Integer.MAX_VALUE;
    private int prev = Integer.MAX_VALUE / 2;
    public int getMinimumDifference(TreeNode root) {
        System.out.println(root.val);
        helper(root);
        return min;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        min = Math.min(min, Math.abs(node.val - prev));
        prev = node.val;
        helper(node.right);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [236,104,701,null,227,null,911]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,48,null,null,12,49]\n
// @lcpr case=end

 */

