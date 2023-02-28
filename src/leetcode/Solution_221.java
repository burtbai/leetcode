package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/maximal-square/">LeetCode URL</a><p>
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = '1' == matrix[i][j] ? 1 : 0;
                } else if ('1' == matrix[i][j]) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        // [
        // ["1","1","1","1","0"],
        // ["1","1","1","1","0"],
        // ["1","1","1","1","1"],
        // ["1","1","1","1","1"],
        // ["0","0","1","1","1"]
        // ]

        // [
        // ["1","1","1","1","0"],
        // ["1","2","2","2","0"],
        // ["1","2","3","3","1"],
        // ["1","2","3","4","2"],
        // ["0","0","1","2","3"]
        // ]
    }
}



