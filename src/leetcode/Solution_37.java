package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/sudoku-solver/">LeetCode URL</a><p>
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 */
class Solution_37 {
    boolean[][] rows = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][][] subboxes = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> spaces = new ArrayList<>();

    void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int row = space[0], col = space[1];
        for (int index = 0; index < 9 && !valid; index++) {
            if (!rows[row][index] && !columns[col][index] && !subboxes[row / 3][col / 3][index]) {
                rows[row][index] = true;
                columns[col][index] = true;
                subboxes[row / 3][col / 3][index] = true;
                board[row][col] = (char) (index + '0' + 1);
                dfs(board, pos + 1);
                rows[row][index] = false;
                columns[col][index] = false;
                subboxes[row / 3][col / 3][index] = false;
            }
        }
    }

    public void solveSudoku(char[][] board) {
        int index;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    index = board[i][j] - '0' - 1;
                    rows[i][index] = true;
                    columns[j][index] = true;
                    subboxes[i / 3][j / 3][index] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public static void main(String[] args) {
        String[] in = {
                "    3 42 ",
                "9524  63 ",
                "      1 9",
                "31 75  6 ",
                " 6 1 4 9 ",
                " 7  96 12",
                "8 7      ",
                " 34  1976",
                " 91 7    "
        };

        char[][] board = new char[9][9];
        for (int i = 0; i < in.length; i++) {
            String[] ins = in[i].split("");
            for (int j = 0; j < ins.length; j++) {
                board[i][j] = ins[j].charAt(0) == ' ' ? '.' : ins[j].charAt(0);
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        Solution_37 s = new Solution_37();
        s.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}



