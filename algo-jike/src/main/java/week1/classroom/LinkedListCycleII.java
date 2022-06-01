package week1.classroom;

import comm.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Describe :leetcode:142
 * @Author : sunzhenning
 * @Since : 2022/6/1 19:42
 */
public class LinkedListCycleII {

    /**
     * 实现方式:使用快慢指针实现方式
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fastHead = head;
        ListNode slowHead = head;
        while (fastHead != null && fastHead.next != null){
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;
            if(fastHead == slowHead){
                while (head != slowHead){
                    head = head.next;
                    slowHead = slowHead.next;
                }
                return head;
            }
        }
        return null;
    }
}
