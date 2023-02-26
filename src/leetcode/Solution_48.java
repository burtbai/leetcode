package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/rotate-image/">LeetCode URL</a><p>
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
class Solution_48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 解法1: 直接旋转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length - 2 * i - 1; j++) {
                // matrix[row][col] = matrix[length - 1 - col][row]
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[length- 1 - i - j ][i];
                matrix[length- 1 - i - j][i] = matrix[length- 1 - i][length- 1 - i - j];
                matrix[length- 1 - i][length - 1 - i - j] = matrix[i + j][length- 1 - i];
                matrix[i + j][length- 1 - i] = temp;
            }
        }

    }

    // 解法2: 先上下对称, 再主对角线对称

    public static void main(String[] args) {

    }
}



