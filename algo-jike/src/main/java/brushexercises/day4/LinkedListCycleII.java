package brushexercises.day4;

import comm.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Describe :
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
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
