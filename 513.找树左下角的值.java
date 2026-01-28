/*
 * @lc app=leetcode.cn id=513 lang=java
 * @lcpr version=30307
 *
 * [513] 找树左下角的值
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int[] res = {0};
        q.add(root);
        Consumer<Queue<TreeNode>> processQueue = (queue) -> {
            int sz = queue.size();
                boolean isLeft = true;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (isLeft && node.left == null && node.right == null) {
                    res[0] = node.val;
                    isLeft = false;
                    continue;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        };
        while (!q.isEmpty()) {
            processQueue.accept(q);
        }
        return res[0];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,null,5,6,null,null,7]\n
// @lcpr case=end

 */

