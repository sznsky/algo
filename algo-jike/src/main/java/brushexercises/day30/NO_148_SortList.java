package brushexercises.day30;

import comm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe : leetcode:148. 排序链表
 * @Author : sunzhenning
 * @Since : 2022/6/28 20:49
 */
public class NO_148_SortList {

    /**
     * 思路：朴素解法：遍历链表。将值存入到集合中，排序，然后将集合转为链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        list.sort((o1,o2)->o1-o2);
        ListNode root = new ListNode();
        ListNode protectHead = root;
        for(int i=0;i<list.size();i++){
            ListNode sortHead = new ListNode();
            sortHead.val = list.get(i);
            root.next = sortHead;
            root = root.next;
        }
        return protectHead.next;
    }



}
