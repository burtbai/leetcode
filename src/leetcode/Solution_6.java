package leetcode;

/**
 * https://leetcode.cn/problems/zigzag-conversion/
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * <p>
 */
class Solution_6 {
    public String convert(String s, int numRows) {
        int l = numRows * 2 - 2;
        if (l <= 0) {
            l = 1;
        }
        int n = s.length() / l + 1;
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < n; j++) {
                int index1 = l * j + i - 1;
                int index2 = -1;
                if (i != 1 && i != numRows) {
                    index2 = l * j + l - i + 1;
                }
                if (index1 < s.length()) {
                    sb.append(s.charAt(index1));
                }
                if (index2 != -1 && index2 < s.length()) {
                    sb.append(s.charAt(index2));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_6 s = new Solution_6();
        String r = s.convert("PAYPALISHIRING", 4);
        System.out.printf("%s\n%s\n\n", r, "PINALSIGYAHRPI");

        r = s.convert("PAYPALISHIRING", 3);
        System.out.printf("%s\n%s\n\n", r, "PAHNAPLSIIGYIR");

        r = s.convert("a", 1);
        System.out.printf("%s\n%s\n\n", r, "a");
    }
}



