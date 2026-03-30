/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30305
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        ListNode prev = dummy;
        ListNode start = head;
        while (true) {
            ListNode lastEnd = prev;
            start = node;
            int cnt = 0;
            while (node != null && cnt < k) {
                prev = node;
                node = node.next;
                cnt++;
            }

            if (cnt < k) {
                break;
            }
            ListNode end = prev;
            if (cnt == k) {
                lastEnd.next = null;
                end.next = null;
                ListNode kCurr = start;
                ListNode kPrev = null;
                while (kCurr != null) {
                    ListNode kNext = kCurr.next;
                    kCurr.next = kPrev;
                    kPrev = kCurr;
                    kCurr = kNext;
                }
                lastEnd.next = kPrev;
                start.next = node;
            }
            prev = start;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n3\n
// @lcpr case=end

 */

