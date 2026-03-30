/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30305
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int size = 0;
        for (char ch : t.toCharArray()) {
            size++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        boolean ok = false;
        List<Integer> res = new LinkedList<>();
        int start = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == window.get(ch)) {
                    count++;
                }
            }
            while (right - left >= t.length()) {
                if (count == size) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    if (window.get(d) == map.get(d)) {
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */

