package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/most-frequent-even-element/">LeetCode URL</a><p>
 * 2404. 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 * <p>
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 105
 */
class Solution_2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                int count = map.getOrDefault(num, 0);
                map.put(num, ++count);
            }
        }

        int maxCount = -1;
        int maxCountKey = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
                maxCountKey = key;
            } else if (map.get(key) == maxCount) {
                maxCount = map.get(key);
                if (key < maxCountKey) {
                    maxCountKey = key;
                }
            }
        }
        return maxCountKey;
    }

    public static void main(String[] args) {

    }
}



