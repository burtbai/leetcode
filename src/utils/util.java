package utils;

/**
 * @author burtbai
 */
public class util {
    public static ListNode constructingListNode(int[] vals) {
        ListNode listNode = new ListNode();
        ListNode p = listNode;
        for (int val: vals) {
            ListNode node = new ListNode(val);
            listNode.next = node;
            listNode = node;
        }
        return p.next;
    }
}
