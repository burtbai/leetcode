package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.ListNode;

import static utils.util.constructingListNode;

/**
 * @see <a href="https://leetcode.cn/problems/add-two-numbers-ii/">LeetCode URL</a><p>
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 */
class Solution_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> deque1 = new ArrayDeque<>();
        Deque<ListNode> deque2 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.push(l2);
            l2 = l2.next;
        }
        ListNode ans = new ListNode();
        int carry = 0;
        while (deque1.size() > 0 || deque2.size() > 0 || carry != 0) {
            int sum = carry;
            if (deque1.size() > 0) {
                sum += deque1.pop().val;
            }
            if (deque2.size() > 0) {
                sum += deque2.pop().val;
            }
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = ans.next;
            ans.next = node;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = constructingListNode(new int[]{7,2,4,3});
        ListNode l2 = constructingListNode(new int[]{5,6,4});
        Solution_445 solution = new Solution_445();
        solution.addTwoNumbers(l1, l2);
    }
}



