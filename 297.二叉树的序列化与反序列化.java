
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=297 lang=java
 * @lcpr version=30400
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        Deque<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
    }

    private TreeNode build(Deque<String> q) {
        String s = q.pollFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = build(q);
        root.right = build(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,3,null,null,4,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 */
