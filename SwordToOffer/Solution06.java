package SwordToOffer;

import java.util.List;

import Public.ListNode;

import java.util.ArrayList;

/**
 * 剑指 offer 6.逆序打印链表
 * 
 * @author KureNaii
 * @since 2021-09-21 12:38:21
 */
public class Solution06 {
    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 使用递归
    public void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
}
