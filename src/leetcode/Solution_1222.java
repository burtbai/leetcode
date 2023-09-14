package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/queens-that-can-attack-the-king/">LeetCode URL</a><p>
 * 1222. 可以攻击国王的皇后
 * 中等
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * <p>
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queens.length <= 63
 * queens[i].length == 2
 * 0 <= queens[i][j] < 8
 * king.length == 2
 * 0 <= king[0], king[1] < 8
 * 一个棋盘格上最多只能放置一枚棋子。
 */
class Solution_1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> direList = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            direList.add(null);
        }
        for (int[] queen : queens) {
            int dx = queen[0] - king[0];
            int dy = queen[1] - king[1];
            if (dx == 0 && dy < 0) {
                List<Integer> d = direList.get(0);
                if (d == null || queen[1] > d.get(1)) {
                    direList.set(0, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dx < 0 && dy < 0 && dx == dy) {
                List<Integer> d = direList.get(1);
                if (d == null || queen[1] > d.get(1)) {
                    direList.set(1, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dy == 0 && dx < 0) {
                List<Integer> d = direList.get(2);
                if (d == null || queen[0] > d.get(0)) {
                    direList.set(2, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dx < 0 && dy > 0 && -dx == dy) {
                List<Integer> d = direList.get(3);
                if (d == null || queen[1] < d.get(1)) {
                    direList.set(3, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dx == 0 && dy > 0) {
                List<Integer> d = direList.get(4);
                if (d == null || queen[1] < d.get(1)) {
                    direList.set(4, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dx > 0 && dy > 0 && dx == dy) {
                List<Integer> d = direList.get(5);
                if (d == null || queen[1] < d.get(1)) {
                    direList.set(5, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dy == 0 && dx > 0) {
                List<Integer> d = direList.get(6);
                if (d == null || queen[0] < d.get(0)) {
                    direList.set(6, Arrays.asList(queen[0], queen[1]));
                }
            } else if (dx > 0 && dy < 0 && dx == -dy) {
                List<Integer> d = direList.get(7);
                if (d == null || queen[1] > d.get(1)) {
                    direList.set(7, Arrays.asList(queen[0], queen[1]));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> d : direList) {
            if (d != null) {
                ans.add(d);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}



