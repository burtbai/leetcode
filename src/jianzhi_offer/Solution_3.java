package jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg">LeetCode URL</a><p>
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 */
public class Solution_3 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null && count >= 1) {
                return num;
            }
            count = 0;
            map.put(num, count + 1);
        }
        return 0;
    }

    public int findRepeatNumber_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                int result = nums[i];
                if (result == nums[result]) {
                    return result;
                }
                nums[i] = nums[result];
                nums[result] = result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
