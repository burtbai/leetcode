package leetcode;

import utils.TreeNode;

/**
 * @see <a href="https://leetcode.cn/problems/validate-binary-search-tree/">LeetCode URL</a><p>
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
class Solution_98 {

    TreeNode p;
    boolean isValidBST = true;

    public boolean inorder(TreeNode node) {
        if (!isValidBST) {
            return false;
        }
        if (node == null) {
            return true;
        }

        inorder(node.left);
        if (p != null) {
            if (p.val >= node.val) {
                isValidBST = false;
                return false;
            }
        }
        p = node;
        inorder(node.right);
        return isValidBST;
    }

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public static void main(String[] args) {

    }
}



