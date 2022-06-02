package week1.task;

import comm.ListNode;

/**
 * @Describe :leetcode:21 【合并两个升序链表】
 * @Author : sunzhenning
 * @Since : 2022/6/2 16:32
 */
public class MergeTwoSortedLists {

    /**
     * 合并两个升序链表，合并完成还是升序
     * 思路：1.创建一个保护节点作为结果链表头，存在结果
     * 2.两个链表在不为空的情况下遍历，把小的节点放到保护节点的尾部
     * 3.遍历保护节点
     * 4.边界：list1和list2有一个为null，则把不为null的给保护节点
     * 5.返回保护节点.next(去掉自己new的头)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个链表头作为保护节点，存放结果
        ListNode protect = new ListNode(0);
        ListNode protectHead = protect;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                protectHead.next = list1;
                list1 = list1.next;
            }else{
                protectHead.next = list2;
                list2 = list2.next;
            }
            protectHead = protectHead.next;
        }
        if(list1 != null && list2 == null){
            protectHead.next = list1;
        }
        if(list1 == null && list2 != null){
            protectHead.next = list2;
        }
        return protect.next;
    }

}
