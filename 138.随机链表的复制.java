/*
 * @lc app=leetcode.cn id=138 lang=java
 * @lcpr version=30305
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }
            node = node.next;
        }
        node = head;
        while (node != null) {
            if (node.next != null) {
                map.get(node).next = map.get(node.next);
            }
            if (node.random != null) {
                map.get(node).random = map.get(node.random);
            }
            node = node.next;
        }
        return map.get(head);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,null],[3,0],[3,null]]\n
// @lcpr case=end

 */

