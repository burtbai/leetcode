package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/">LeetCode URL</a><p>
 * 1287. 有序数组中出现次数超过25%的元素
 * 简单
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * <p>
 * 请你找到并返回这个整数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
class Solution_1287 {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length / 4;
        for (int i = 0; i + len < arr.length; i++) {
            if (arr[i] == arr[i + len]) {
                return arr[i];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {

    }
}



