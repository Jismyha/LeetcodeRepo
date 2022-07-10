package Public;

/**
 * 公用链表节点类
 * 
 * @author KureNaii
 * @version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
