package brushexercises.day30;

import comm.ListNode;

/**
 * @Describe : leetcode:141. 环形链表
 * @Author : sunzhenning
 * @Since : 2022/6/28 15:14
 */
public class NO_141_LinkedListCycle {

    /**
     * 快慢指针判断环的是否存在
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

}
