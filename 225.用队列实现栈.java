/*
 * @lc app=leetcode.cn id=225 lang=java
 * @lcpr version=30307
 *
 * [225] 用队列实现栈
 */

// @lc code=start

import java.util.Queue;

class MyStack {
    Queue<Integer> q1, q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int res = q1.peek();
        while (!q1.isEmpty()) {
            res = q1.poll();
            if (!q1.isEmpty()) {
                q2.add(res);
            }
        }
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        return res;
    }
    
    public int top() {
        int res = q1.peek();
        while (!q1.isEmpty()) {
            res = q1.poll();
            q2.add(res);
        }
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        return res;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end



/*
// @lcpr case=start
// ["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]\n
// @lcpr case=end

 */

