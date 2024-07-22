package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/harshad-number/">LeetCode URL</a><p>
 * 3099. 哈沙德数
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： x = 18
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： x = 23
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 100
 */
class Solution_3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int number = x;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return number % sum == 0 ? sum : -1;
    }

    public static void main(String[] args) {

    }
}



