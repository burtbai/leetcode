package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/">LeetCode URL</a><p>
 * 2309. 兼具大小写的最好英文字母
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * <p>
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * <p>
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lEeTcOdE"
 * 输出："E"
 * 解释：
 * 字母 'E' 是唯一一个大写和小写形式都出现的字母。
 * 示例 2：
 * <p>
 * 输入：s = "arRAzFif"
 * 输出："R"
 * 解释：
 * 字母 'R' 是大写和小写形式都出现的最好英文字母。
 * 注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
 * 示例 3：
 * <p>
 * 输入：s = "AbCdEfGhIjK"
 * 输出：""
 * 解释：
 * 不存在大写和小写形式都出现的字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写和大写英文字母组成
 */
class Solution_2309 {
    public String greatestLetter(String s) {
        Set<Character> upperMap = new HashSet<>();
        Set<Character> lowerMap = new HashSet<>();
        char greatestLetter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char compareC = Character.toUpperCase(c);
            if ('a' <= c && c <= 'z') {
                if (upperMap.contains(compareC) && compareC > greatestLetter) {
                    greatestLetter = compareC;
                }
                lowerMap.add(compareC);
            } else {
                if (lowerMap.contains(compareC) && compareC > greatestLetter) {
                    greatestLetter = compareC;
                }
                upperMap.add(compareC);
            }
        }
        return greatestLetter == 0 ? "" : String.valueOf(greatestLetter);
    }

    public String greatestLetter_1(String s) {
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            map.add(s.charAt(i));
        }
        for (char c = 'Z'; c >= 'A'; c--) {
            if (map.contains(c) && map.contains(Character.toLowerCase(c))) {
                return String.valueOf(c);
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}



