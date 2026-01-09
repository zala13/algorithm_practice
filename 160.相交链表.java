/*
 * @lc app=leetcode.cn id=160 lang=java
 * @lcpr version=30305
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        int len1 = 0, len2 = 0;
        while (n1 != null) {
            len1++;
            n1 = n1.next;
        }
        while (n2 != null) {
            len2++;
            n2 = n2.next;
        }
        n1 = headA; n2 = headB;
        while (len1 > len2) {
            n1 = n1.next;
            len1--;
        }
        while (len1 < len2) {
            n2 = n2.next;
            len2--;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n[1,9,1,2,4]\n[3,2,4]\n3\n1\n
// @lcpr case=end

// @lcpr case=start
// 0\n[2,6,4]\n[1,5]\n3\n2\n
// @lcpr case=end

 */

