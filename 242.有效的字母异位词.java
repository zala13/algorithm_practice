/*
 * @lc app=leetcode.cn id=242 lang=java
 * @lcpr version=30306
 *
 * [242] 有效的字母异位词
 */

// @lc code=start

import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map1 = encode(s);
        int[] map2 = encode(t);
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] encode(String str) {
        int[] res = new int[26];
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            System.out.println(idx);
            res[idx]++;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "anagram"\n"nagaram"\n
// @lcpr case=end

// @lcpr case=start
// "rat"\n"car"\n
// @lcpr case=end

 */

