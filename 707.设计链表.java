/*
 * @lc app=leetcode.cn id=707 lang=java
 * @lcpr version=30305
 *
 * [707] 设计链表
 */

// @lc code=start
public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyLinkedList {
    int size = 0;
    ListNode head = new ListNode(-1);
    ListNode tail = new ListNode(-1);
    public MyLinkedList() {
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int index) {
        if (index >= this.size || index < 0) {
            return -1;
        }
        ListNode curr = head;
        for (int i = 0; i <= index; i++) {
            if (curr == null) {
                return -1;
            }
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        newHead.prev = head;
        head.next = newHead;
        newHead.next.prev = newHead;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        newTail.next = tail;
        newTail.prev = tail.prev;
        tail.prev = newTail;
        newTail.prev.next = newTail;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        while (index >= 0) {
            curr = curr.next;
            index--;
        }
        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode curr = head;
        while (index >= 0) {
            curr = curr.next;
            index--;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = null;
        curr.prev = null;
        size--;
    }
}
// 1 3
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end



/*
// @lcpr case=start
// ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n[[],[1],[3],[1,2],[1],[1],[1]]\n
// @lcpr case=end

 */

