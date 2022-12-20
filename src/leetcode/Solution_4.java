package leetcode;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
class Solution_4 {
    private boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int max = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (j - i < max) {
                    break;
                }
                if (isPalindromic(s, i, j)) {
                    if (j - i > max) {
                        max = j - i;
                        maxStart = i;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart + max + 1);
    }

    private int extendPalindromic(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        return end - start - 1;
    }

    public String longestPalindrome_1(String s) {
        int max = 0;
        int maxStart = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = extendPalindromic(s, i, i);
            int even = extendPalindromic(s, i, i + 1);
            if (odd > max) {
                max = odd;
                maxStart = i - max / 2;
            }
            if (even > max) {
                max = even;
                maxStart = i - max / 2 + 1;
            }
        }
        return s.substring(maxStart, maxStart + max);
    }

    public static void main(String[] args) {
        Solution_4 s = new Solution_4();
        s.longestPalindrome("babad");
    }
}



