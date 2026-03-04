/*
 * @lc app=leetcode.cn id=1024 lang=java
 * @lcpr version=30400
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int time) {
        if (time == 0) {
            return 0;
        }
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int res = 0;
        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                return res;
            }
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]\n10\n
// @lcpr case=end

// @lcpr case=start
// [[0,1],[1,2]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]\n9\n
// @lcpr case=end

 */

