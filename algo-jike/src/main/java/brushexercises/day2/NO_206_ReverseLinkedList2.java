package brushexercises.day2;

import comm.ListNode;

/**
 * @Describe : 反转链表206
 * @Author : sunzhenning
 * @Since : 2022/7/13 16:33
 */
public class NO_206_ReverseLinkedList2 {


    public ListNode reverse(ListNode head){
        ListNode last = null;
        while (head != null){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        return last;
    }
}
