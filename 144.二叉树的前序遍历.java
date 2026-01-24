/*
 * @lc app=leetcode.cn id=144 lang=java
 * @lcpr version=30307
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start

import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        while (!stk.empty() || root != null) {
            while (root != null) {
                stk.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,8,null,null,6,7,9]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

