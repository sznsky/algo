package brushexercises.day30;

import comm.ListNode;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/28 10:28
 */
public class NO_142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

            }
        }

        return null;
    }
}
