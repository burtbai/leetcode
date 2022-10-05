package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-palindrome/
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输入:1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 */
class Solution_409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int longest = 0;
        boolean odd = false;
        for (Integer i : map.values()) {
            if (i % 2 == 1) {
                odd = true;
                longest += i - 1;
            } else {
                longest += i;
            }
        }

        if (odd) {
            longest += 1;
        }

        return longest;
    }

    public static void main(String[] args) {

    }
}



