/*
 * @lc app=leetcode.cn id=404 lang=java
 * @lcpr version=30307
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        int[] res = {0};
        rightQueue.add(root);
        BiConsumer<Queue<TreeNode>, Boolean> processQueue = (queue, isLeft) -> {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (isLeft && node.left == null && node.right == null) {
                    res[0] += node.val;
                    continue;
                }
                if (node.left != null) {
                    leftQueue.offer(node.left);
                }
                if (node.right != null) {
                    rightQueue.offer(node.right);
                }
            }
        };
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            processQueue.accept(leftQueue, true);
            processQueue.accept(rightQueue, false);
        }
        return res[0];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

