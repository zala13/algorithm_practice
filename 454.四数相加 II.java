/*
 * @lc app=leetcode.cn id=454 lang=java
 * @lcpr version=30305
 *
 * [454] 四数相加 II
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum12 = nums1[i] + nums2[j];
                if (map.containsKey(sum12)) {
                    map.put(sum12, map.getOrDefault(sum12, 0) + 1);
                } else {
                    map.put(sum12, 1);
                }
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum34 = -(nums3[i] + nums4[j]);
                if (map.containsKey(sum34)) {
                    res += map.get(sum34);
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2]\n[-2,-1]\n[-1,2]\n[0,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n[0]\n[0]\n
// @lcpr case=end

 */

