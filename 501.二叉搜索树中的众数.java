/*
 * @lc app=leetcode.cn id=501 lang=java
 * @lcpr version=30307
 *
 * [501] 二叉搜索树中的众数
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
    private int count = 0, maxCount = 0;
    private int[] res;
    private List<Integer> resList = new LinkedList<>();
    private int prev = Integer.MAX_VALUE;
    public int[] findMode(TreeNode root) {
        helper(root);
        return resList.stream().mapToInt(num -> num).toArray();
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        int currVal = node.val;
        if (currVal == prev) {
            count++;
        } else {
            count = 1;
            prev = currVal;
        }

        if (count > maxCount) {
            maxCount = count;
            resList.clear();
            resList.add(currVal);
        } else if (count == maxCount) {
            resList.add(currVal);
        }
        helper(node.right);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

