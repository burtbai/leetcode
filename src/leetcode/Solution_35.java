package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/search-insert-position/">LeetCode URL</a><p>
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
class Solution_35 {
    int binSearch(int[] nums, int b, int e, int target) {
        int m = (b + e) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[e] < target) {
            return e + 1;
        } else if (nums[b] > target) {
            return b;
        } else if (nums[m] < target) {
            return binSearch(nums, m + 1, e, target);
        } else {
            return binSearch(nums, b, m - 1, target);
        }
    }

    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {

    }
}



