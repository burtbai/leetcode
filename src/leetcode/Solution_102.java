package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">LeetCode URL</a><p>
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */

class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> temp;
        List<Integer> e;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            temp = new ArrayList<>();
            e = new ArrayList<>();
            for (TreeNode node : queue) {
                if (node != null) {
                    e.add(node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }
            }

            if (e.size() == 0) {
                return result;
            }
            result.add(e);
            queue = temp;
        }

        return result;
    }

    public static void main(String[] args) {
    }
}



