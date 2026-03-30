/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30304
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        Map<Character, Integer> charToTimes = new HashMap<>();
        int maxLength = 0;
        while (right < n) {
            char rChar = s.charAt(right);
            charToTimes.put(rChar, charToTimes.getOrDefault(rChar, 0) + 1);
            right++;
            char lChar = s.charAt(left);
            while (left < right && charToTimes.get(rChar) > 1) {
                charToTimes.put(lChar, charToTimes.get(lChar) - 1);
                left++;
                lChar = s.charAt(left);
            }
            int currLength = right - left;
            maxLength = Math.max(currLength, maxLength);
        }
        return maxLength;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

 */

