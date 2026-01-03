/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30305
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
            inDegree[to]++;
        }
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        int count = 0;
        while (!dq.isEmpty()) {
            int sz = dq.size();
            for (int i = 0; i < sz; i++) {
                int from = dq.pop();
                count++;
                for (int to : graph[from]) {
                    inDegree[to]--;
                    if (inDegree[to] == 0) {
                        dq.add(to);
                    }
                }
            }
        }
        return count == numCourses;

    }
}
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

 */

