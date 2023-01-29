package leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/running-sum-of-1d-array/">LeetCode URL</a><p>
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
class Solution_1480 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution_1480 s = new Solution_1480();
        int[] result = s.runningSum(nums);
        System.out.printf("%s", Arrays.toString(result));
    }
}



