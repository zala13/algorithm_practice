/*
 * @lc app=leetcode.cn id=257 lang=java
 * @lcpr version=30307
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start

import java.util.LinkedList;
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        backtrack(root);
        return res;
    }
    List<String> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    private void backtrack(TreeNode node) {        
        if (node.left == null) {
            res.add(new String(path.toString()));
        } else {
            path.add(node.left.val);
            backtrack(node.left);
            path.removeLast();
        }
        if (node.right == null) {
            res.add(new String(path.toString()));
        } else {
            path.add(node.right.val);
            backtrack(node.right);
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,null,5]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

