/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30305
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return build(nums, 0, n - 1); 
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        TreeNode node = new TreeNode(nums[(left + right) / 2]);
        node.left = build(nums, left, (left + right) / 2 - 1);
        node.right = build(nums, (left + right) / 2 + 1, right);
        return node;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */

