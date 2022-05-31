package brushexercises.day2;

import comm.ListNode;

/**
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/5/31 14:23
 */
public class ReverseLinkedList {

    public ListNode reverse(ListNode head){
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
