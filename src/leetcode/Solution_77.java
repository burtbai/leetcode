package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/combinations/">LeetCode URL</a><p>
 * 77. 组合
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 */
class Solution_77 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        if (temp.size() + n - cur + 1 < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {

    }
}



