package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/">LeetCode URL</a><p>
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {

    }
}



