/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30305
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            length++;
            prev = slow;
            slow = slow.next;
        }
        if (length == 0) {
            return true;
        }
        prev.next = null;
        ListNode start1 = head;
        ListNode start2 = fast == null ? slow : slow.next;
        
        // 反转前半部分
        ListNode pre = null;
        ListNode curr = start1;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        start1 = pre;

        while (start1 != null && start2 != null) {
            if (start1.val != start2.val) {
                return false;
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        return true;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [1,2,2,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2]\n
 * // @lcpr case=end
 * 
 */
