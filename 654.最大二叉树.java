/*
 * @lc app=leetcode.cn id=654 lang=java
 * @lcpr version=30307
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxVal = nums[start];
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = helper(nums, start, maxIdx - 1);
        node.right = helper(nums, maxIdx + 1, end);
        return node;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [3,2,1,6,0,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,1]\n
 * // @lcpr case=end
 * 
 */
