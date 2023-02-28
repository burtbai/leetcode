package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/word-search/">LeetCode URL</a><p>
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
class Solution_79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean ans = check(board, i, j, word, 0, vis);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, String word, int k, boolean[][] vis) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        vis[i][j] = true;
        boolean result = false;
        for (int d = 0; d < direction.length; d++) {
            int newI = i + direction[d][0];
            int newJ = j + direction[d][1];
            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length) {
                if (!vis[newI][newJ]) {
                    boolean ans = check(board, newI, newJ, word, k + 1, vis);
                    if (ans) {
                        result =  true;
                        break;
                    }
                }
            }
        }
        vis[i][j] = false;
        return result;
    }

    public static void main(String[] args) {

    }
}



