/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30305
 *
 * [230] 二叉搜索树中第 K 小的元素
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
    private int res = 0, count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        midtrack(root, k);
        return res;
    }

    private void midtrack(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        midtrack(node.left, k);
        if (k > count) {
            count++;
            if (k == count) {
                res = node.val;
            }
        }
        midtrack(node.right, k);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

