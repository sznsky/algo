package week2.task;

import comm.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Describe : leetcode:23【合并K个升序链表】
 * @Author : sunzhenning
 * @Since : 2022/6/9 3:39
 */
public class MergeKSortedLists {

    /**
     * 合并k个链表：方法一：朴素解法
     * 思路：1.将k个链表遍历，将所有值放到List集合中，将集合排序
     * 2.将该集合转为链表。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allNumList = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode headNode = lists[i];
            while (headNode != null){
                Integer val = headNode.val;
                allNumList.add(val);
                headNode = headNode.next;
            }
        }
        ListNode protect = new ListNode(0);
        if(allNumList.size() > 0){
            allNumList = allNumList.stream().sorted().collect(Collectors.toList());
            //注意：将project的值指向head,由于他们在内存中都是指向的同一个地址，所以head的改变，会导致protect的值的改变。
            ListNode head = protect;
            for(int i=0;i<allNumList.size();i++){
                ListNode tmp = new ListNode(allNumList.get(i));
                head.next = tmp;
                head = tmp;
            }
        }
        return protect.next;
    }
}
