package brushexercises.day3;

import comm.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Describe : leetcode:141
 * @Author : sunzhenning
 * @Since : 2022/5/31 18:40
 */
public class LinkedListCycle {

    /**
     * 暴力解法：
     * 1.遍历链表
     * 2.将每个链表头放到集合中
     * 3.如果集合中存在这个链表，说明是存在环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
            if(list.contains(head)){
                return true;
            }
        }
        return false;
    }

    /**
     * 优化解法
     * 使用set存放链表，能够有效的节约内存
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }





}
