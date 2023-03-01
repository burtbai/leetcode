package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/sort-colors/">LeetCode URL</a><p>
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
class Solution_75 {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 三路快排
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length-1;
        int m = 0;
        while (m < j) {
            if (nums[m] > 1) {
                swap(nums, m, j);
                j--;
            } else if (nums[m] < 1) {
                swap(nums, m, i);
                i++;
                m++;
            } else {
                m++;
            }
        }
    }

    public static void main(String[] args) {
        Solution_75 s = new Solution_75();
        s.sortColors(new int[]{2, 0, 1});
        s.sortColors(new int[]{0, 2, 0});
    }
}



