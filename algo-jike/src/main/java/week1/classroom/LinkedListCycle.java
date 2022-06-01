package week1.classroom;

import comm.ListNode;

/**
 * leetcode:141
 * 141. 环形链表
 */
public class LinkedListCycle {


    /**
     * 思路：1.将每个头节点的链表加入到set或者list中，加入之前判断是否存在，存在则是重复。这个时间复杂度是O(N)
     * 2.使用快慢指针的方法，快指针每次走两步，慢指针走一步，如果快指针追上慢指针，说明存在环。时间复杂度是O(1)
     * 本方法使用方法2解决
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                return true;
            }
        }
        return false;
    }

}
