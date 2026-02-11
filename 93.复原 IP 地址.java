/*
 * @lc app=leetcode.cn id=93 lang=java
 * @lcpr version=30307
 *
 * [93] 复原 IP 地址
 */

// @lc code=start

import java.util.List;

class Solution {
    List<List<String>> res = new LinkedList<>();
    List<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        List<String> ans = new LinkedList<>();
        for (List<String> str : res) {
            StringBuilder oneRes = new StringBuilder();
            for (String partStr : str) {
                oneRes.append(new StringBuilder(partStr));
                oneRes.append('.');
            }
            oneRes.deleteCharAt(oneRes.length() - 1);
            ans.add(oneRes.toString());
        }
        return ans;
    }

    private void backtrack(String s, int index) {
        if (path.size() == 4 && index == s.length()) {
            res.add(new LinkedList(path));
        }
        for (int i = index; i < s.length(); i++) {
            if (!isValid(s, index, i)) {
                continue;
            }
            path.add(new String(s.substring(index, i + 1)));
            backtrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (end - start > 2 || end - start < 0)  {
            return false;
        }
        if (s.charAt(start) == '0') {
            if (end - start == 0) {
                return true;
            } else {
                return false;
            }
        }
        String str = s.substring(start, end + 1);
        if (str.length() == 3) {
            int num = (str.charAt(0) - '0') * 100 + (str.charAt(1) - '0') * 10 + (str.charAt(2) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "25525511135"\n
// @lcpr case=end

// @lcpr case=start
// "0000"\n
// @lcpr case=end

// @lcpr case=start
// "101023"\n
// @lcpr case=end

 */

