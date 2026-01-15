/*
 * @lc app=leetcode.cn id=349 lang=java
 * @lcpr version=30306
 *
 * [349] 两个数组的交集
 */

// @lc code=start

import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            if (!map1.containsKey(num)) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }
        }
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                map1.remove(num);
                res.add(num);
            }
        }
        int n = res.size();
        int[] resArray = new int[n];
        for (int i = 0; i < n; i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,1]\n[2,2]\n
// @lcpr case=end

// @lcpr case=start
// [4,9,5]\n[9,4,9,8,4]\n
// @lcpr case=end

 */

