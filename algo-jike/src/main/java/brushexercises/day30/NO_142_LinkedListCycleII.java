package brushexercises.day30;

import comm.ListNode;

/**
 * @Describe : leetcode:142. 环形链表 II
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
            //快慢指针相遇了
            if(fast == slow){
                //移动慢指针和头部指针，他们相遇的地方就是环开始的地方
                while(slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
