package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/add-strings/">LeetCode URL</a><p>
 * 0415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
class Solution_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0) {
            char c1 = '0';
            if (i >= 0) {
                c1 = num1.charAt(i);
            }
            char c2 = '0';
            if (j >= 0) {
                c2 = num2.charAt(j);
            }
            char c = (char) (c1 + c2 - '0' + carry);
            if (c > '9') {
                c = (char) (c - '9' - 1 + '0');
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(c);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_415 s = new Solution_415();
        s.addStrings("456", "77");
        for (int i = 0 + '0'; i <= 10 + '0'; i++) {
            System.out.printf("%d: %c\n", i, (char) i);
        }
        for (int i = 0 + 'a'; i <= 26 + 'a'; i++) {
            System.out.printf("%d: %c\n", i, (char) i);
        }
    }
}



