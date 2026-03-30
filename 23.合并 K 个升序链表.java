/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30305
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = mergeList(node, lists[i]);
        }
        return node;
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */

