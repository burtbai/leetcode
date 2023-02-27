package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/">LeetCode URL</a><p>
 * 1144. 递减元素使数组呈锯齿状
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * <p>
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
class Solution_1144 {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        // 偶数位小
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            if (i == 0) {
                if (nums[i] >= nums[i + 1]) {
                    ans += nums[i] - nums[i + 1] + 1;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] >= nums[i - 1]) {
                    ans += nums[i] - nums[i - 1] + 1;
                }
            } else if (nums[i] >= nums[i + 1] || nums[i] >= nums[i - 1]) {
                ans += nums[i] - Math.min(nums[i + 1], nums[i - 1]) + 1;
            }
        }
        // 奇数位小
        int ans1 = 0;
        for (int i = 1; i < nums.length; i += 2) {
            if (i == nums.length - 1) {
                if (nums[i] >= nums[i - 1]) {
                    ans1 += nums[i] - nums[i - 1] + 1;
                }
            } else if (nums[i] >= nums[i + 1] || nums[i] >= nums[i - 1]) {
                ans1 += nums[i] - Math.min(nums[i + 1], nums[i - 1]) + 1;
            }
        }
        return Math.min(ans, ans1);
    }

    public static void main(String[] args) {

    }
}



