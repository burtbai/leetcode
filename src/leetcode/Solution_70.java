package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/">LeetCode URL</a><p>
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 */
class Solution_70 {
    int[] ans = new int[46];

    {
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
    }

    public int climbStairs(int n) {
        if (ans[n] != 0) {
            return ans[n];
        }
        int res1 = climbStairs(n - 1);
        if (ans[n - 1] != 0) {
            ans[n - 1] = res1;
        }
        int res2 = climbStairs(n - 2);
        if (ans[n - 2] != 0) {
            ans[n - 2] = res2;
        }
        ans[n] = res1 + res2;
        return ans[n];
    }

    public static void main(String[] args) {

    }
}



