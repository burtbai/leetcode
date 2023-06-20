package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems//longest-common-prefix/">LeetCode URL</a><p>
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        String shortest = strs[0];
        int min = strs[0].length();
        for (String str : strs) {
            if (min > str.length()) {
                min = str.length();
                shortest = str;
            }
        }
        String ans = "";
        for (int i = 0; i < shortest.length(); i++) {
            for (String str : strs) {
                if (shortest.charAt(i) != str.charAt(i)) {
                    return ans;
                }
            }
            ans += shortest.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}



