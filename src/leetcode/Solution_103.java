package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */
class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        boolean isLeft = true;
        while (queue.size() > 0) {
            List<Integer> e = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();
            for(int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                if (isLeft) {
                    e.add(node.val);
                } else {
                    e.add(queue.get(queue.size() - i - 1).val);
                }

                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            res.add(e);
            queue = temp;
            isLeft = !isLeft;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}



