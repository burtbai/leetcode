package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/number-of-islands/">LeetCode URL</a><p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution_200 {

    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean dfs(char[][] grid, int[][] gridFlag, int x, int y, int flag) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (gridFlag[x][y] != 0 || grid[x][y] == '0') {
            return false;
        }
        gridFlag[x][y] = flag;
        for (int[] dir : direction) {
            dfs(grid, gridFlag, x + dir[0], y + dir[1], flag);
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        int[][] gridFlag = new int[grid.length][grid[0].length];
        int flag = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean exist = dfs(grid, gridFlag, i, j, flag);
                if (exist) {
                    flag++;
                }
            }
        }
        return flag - 1;
    }

    public static void main(String[] args) {

    }
}



