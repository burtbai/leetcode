package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.cn/problems/recover-binary-search-tree/">LeetCode URL</a><p>
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 */
class Solution_99 {
    TreeNode x, y, pre;
    int find = 0;

    public void inorder(TreeNode node) {
        if (node == null || find >= 2) {
            return;
        }
        inorder(node.left);
        if (pre != null && pre.val > node.val) {
            if (x == null) {
                x = pre;
            }
            y = node;
            find++;
        }
        pre = node;
        inorder(node.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    public static void main(String[] args) {

    }
}



