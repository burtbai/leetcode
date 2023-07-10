package leetcode;

import java.util.stream.IntStream;

/**
 * @see <a href="https://leetcode.cn/problems/plus-one/">LeetCode URL</a><p>
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
class Solution_66 {
    public int[] plusOne(int[] digits) {
        int d = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (d == 0) {
                break;
            }
            int a = digits[i] + 1;
            d = a / 10;
            digits[i] = a % 10;
        }
        if (d == 1) {
            int[] ans = new int[]{1};
            return IntStream.concat(IntStream.of(ans), IntStream.of(digits)).toArray();
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}



