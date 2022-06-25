package brushexercises.day27;

import comm.ListNode;

/**
 * @Describe : leetcode:206. 反转链表
 * @Author : sunzhenning
 * @Since : 2022/6/25 0:40
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while(head != null){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        return last;
    }
}
