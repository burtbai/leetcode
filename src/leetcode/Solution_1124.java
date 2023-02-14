package leetcode;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.cn/problems/longest-well-performing-interval/">LeetCode URL</a><p>
 * 1124. 表现良好的最长时间段
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 示例 2：
 * <p>
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hours.length <= 104
 * 0 <= hours[i] <= 16
 */
class Solution_1124 {
    public int longestWPI(int[] hours) {
        Stack<Integer> stack = new Stack<>();
        int[] sums = new int[hours.length + 1];
        stack.push(0);
        for (int i = 1; i <= hours.length; i++) {
            sums[i] = sums[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (sums[stack.peek()] > sums[i]) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = hours.length; i > 0; i--) {
            while (!stack.isEmpty() && sums[stack.peek()] < sums[i]) {
                max = Math.max(max, i - stack.pop());
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}



