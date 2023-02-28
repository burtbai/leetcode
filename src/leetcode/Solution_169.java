package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/majority-element/">LeetCode URL</a><p>
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
class Solution_169 {
    public int majorityElement(int[] nums) {
        // https://zh.wikipedia.org/zh-hans/%E5%A4%9A%E6%95%B0%E6%8A%95%E7%A5%A8%E7%AE%97%E6%B3%95
        // 多数投票算法、摩尔投票算法
        // 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
        int count = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count += ans == nums[i] ? 1 : -1;
            if (count == 0) {
                ans = nums[i];
                count = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}



