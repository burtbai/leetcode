package leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @see <a href="https://leetcode.cn/problems/detonate-the-maximum-bombs/">LeetCode URL</a><p>
 * 2101. 引爆最多的炸弹
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[2,1,3],[6,1,4]]
 * 输出：2
 * 解释：
 * 上图展示了 2 个炸弹的位置和爆炸范围。
 * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
 * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
 * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,1,5],[10,10,5]]
 * 输出：1
 * 解释：
 * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * 输出：5
 * 解释：
 * 最佳引爆炸弹为炸弹 0 ，因为：
 * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
 * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
 * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
 * 所以总共有 5 个炸弹被引爆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 */
class Solution_2101 {

    static class Bomb {
        int x;
        int y;
        int r;
        int index;

        Bomb(int x, int y, int r, int index) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.index = index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, r, index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bomb bomb = (Bomb) o;
            return index == bomb.index && x == bomb.x && y == bomb.y && r == bomb.r;
        }
    }

    void detonation(Map<Bomb, List<Bomb>> map, Bomb bomb, Set<Bomb> flag) {
        if (flag.contains(bomb)) {
            return;
        }
        flag.add(bomb);
        for (Bomb b : map.get(bomb)) {
            detonation(map, b, flag);
            flag.add(b);
        }
    }

    public int maximumDetonation_1(int[][] bombs) {
        Map<Bomb, List<Bomb>> map = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            Bomb bomb1 = new Bomb(bombs[i][0], bombs[i][1], bombs[i][2], i);
            List<Bomb> temp = new ArrayList<>();
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                Bomb bomb2 = new Bomb(bombs[j][0], bombs[j][1], bombs[j][2], j);
                if ((Math.pow(bomb1.x - bomb2.x, 2) + Math.pow(bomb1.y - bomb2.y, 2)) <= (Math.pow(bomb1.r, 2))) {
                    temp.add(bomb2);
                }
            }
            map.put(bomb1, temp);
        }

        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            int[] bomb = bombs[i];
            Set<Bomb> flag = new HashSet<>();
            detonation(map, new Bomb(bomb[0], bomb[1], bomb[2], i), flag);
            ans = Math.max(ans, flag.size());
        }
        return ans;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        BitSet[] f = new BitSet[n];
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            f[i] = new BitSet(n);
            for (int j = 0; j < n; j++) {
                long dx = x - bombs[j][0];
                long dy = y - bombs[j][1];
                if (dx * dx + dy * dy <= r * r) {
                    f[i].set(j); // i 可以到达 j
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (BitSet fi : f) {
                if (fi.get(k)) { // i 可以到达 k
                    fi.or(f[k]); // i 也可以到 k 可以到达的点
                }
            }
        }

        int ans = 0;
        for (BitSet s : f) {
            ans = Math.max(ans, s.cardinality()); // 集合大小的最大值
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2101 solution = new Solution_2101();
//        int ans = solution.maximumDetonation(new int[][]{{1, 1, 5}, {10, 10, 5}});
//        int ans = solution.maximumDetonation(new int[][]{{4, 4, 3}, {4, 4, 3}});
//        int ans = solution.maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}});
        int ans = solution.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}});
//        int ans = solution.maximumDetonation(new int[][]{{54, 95, 4}, {99, 46, 3}, {29, 21, 3}, {96, 72, 8}, {49, 43, 3}, {11, 20, 3}, {2, 57, 1}, {69, 51, 7}, {97, 1, 10}, {85, 45, 2}, {38, 47, 1}, {83, 75, 3}, {65, 59, 3}, {33, 4, 1}, {32, 10, 2}, {20, 97, 8}, {35, 37, 3}});
        System.out.println(ans);
    }
}



