package Public;

/**
 * List 类
 * 
 * @author KureNaii
 * @since 2022-07-30 16:01:57
 */
public class List {
    /**
     * 递归反转链表
     * 
     * @param head
     * @return
     */
    public ListNode reverseByRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseByRecur(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    /**
     * 迭代反转链表
     * 使用三指针
     * 
     * @param head
     * @return
     */
    public ListNode reverseByItr(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while (cur != null) {
            // 每次循环使 cur 指向 pre, nxt 用于记录 cur 后面的指针
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
