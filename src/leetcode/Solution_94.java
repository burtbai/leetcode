package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">LeetCode URL</a><p>
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
class Solution_94 {
    List<Integer> ans = new ArrayList<>();
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        ans.add(node.val);
        inorder(node.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }

    public static void main(String[] args) {

    }
}



