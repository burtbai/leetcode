package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/reverse-integer/">LeetCode URL</a><p>
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * -2^31 <= x <= 2^31 - 1
 */
class Solution_7 {
    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        String s = String.valueOf(Math.abs(x));
        String reverse = new StringBuilder(s).reverse().toString();
        if (reverse.length() == 10 && ((x > 0 && reverse.compareTo("2147483647") > 0) || (x < 0 && reverse.compareTo("2147483648") > 0))) {
            return 0;
        }
        return x < 0 ? -Integer.parseInt(s) : Integer.parseInt(s);
    }

    public int reverse_1(int x) {
        int result = 0;
        int tmp = result;
        while (x != 0) {
            tmp = result;
            result = (result * 10) + (x % 10);
            x /= 10;
            if (result / 10 != tmp) return 0;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}



