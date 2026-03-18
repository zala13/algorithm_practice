/*
 * @lc app=leetcode.cn id=116 lang=java
 * @lcpr version=30400
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new LinkedList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node node = q.removeFirst();
                if (i == sz - 1) {
                    node.next = null;
                } else {
                    Node next = q.removeFirst();
                    node.next = next;
                    q.addFirst(next);
                }
                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }
                System.out.println(node.val);
            }
        }
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6,7]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

