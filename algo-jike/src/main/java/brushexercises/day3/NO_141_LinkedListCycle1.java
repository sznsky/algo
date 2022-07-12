package brushexercises.day3;

import comm.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 141. 环形链表
 * @Describe : leetcode:141
 * @Author : sunzhenning
 * @Since : 2022/5/31 18:40
 */
public class NO_141_LinkedListCycle1 {

    /**
     * 1.快慢指针
     * 快指针走2，慢指针走1
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用set,判断唯一性
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
           if(!set.add(head)){
                return true;
           }
            head = head.next;
        }
        return false;
    }





}
