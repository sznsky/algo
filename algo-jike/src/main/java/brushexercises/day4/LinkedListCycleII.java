package brushexercises.day4;

import comm.ListNode;

import java.util.*;

/**
 * @Describe :leetcode:142
 * @Author : sunzhenning
 * @Since : 2022/6/1 19:42
 */
public class LinkedListCycleII {

    /**
     * 实现方式
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<>();
        int i = 0;
        while(head != null){
            if(map.containsKey(head)){
                return head;
            }
            map.put(head,i);
            head = head.next;
            i++;
        }
        return null;
    }

    /**
     * 实现方式1
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针的实现方式
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            //快指针一次走两步，慢指针一次走一步
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
