package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/generate-parentheses/">LeetCode URL</a><p>
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
class Solution_22 {
    public List<String> generateParenthesis(int n) {
        LinkedList<LinkedList<String>> dp = new LinkedList<>();
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        dp.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        dp.add(list1);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> listTemp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                LinkedList<String> listP = dp.get(j);
                LinkedList<String> listQ = dp.get(i - 1 - j);
                for (String p : listP) {
                    for (String q : listQ) {
                        listTemp.add("(" + p + ")" + q);
                    }
                }
            }
            dp.add(listTemp);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {

    }
}



