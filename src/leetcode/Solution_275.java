package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/h-index-ii/">LeetCode URL</a><p>
 * 275. H 指数 II
 * 中等
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * <p>
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * <p>
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [0,1,3,5,6]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
 * 示例 2：
 * <p>
 * 输入：citations = [1,2,100]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 105
 * 0 <= citations[i] <= 1000
 * citations 按 升序排列
 */
class Solution_275 {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (citations[mid] < citations.length - mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return citations.length - l;
    }

    public static void main(String[] args) {
        Solution_275 s = new Solution_275();
        s.hIndex(new int[]{0,0,0});
    }
}



