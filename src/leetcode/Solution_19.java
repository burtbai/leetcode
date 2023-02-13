package leetcode;

/**
 * @see <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">LeetCode URL</a><p>
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
class Solution_19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode index1 = new ListNode(0, head), index2 = head;
        while (index2.next != null) {
            i++;
            if (i >= n) {
                index1 = index1.next;
            }
            index2 = index2.next;
        }
        if (index1.next == head) {
            return index1.next.next;
        }
        index1.next = index1.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}



