package brushexercises;

import comm.ListNode;

/**
 * @Describe : 21. 合并两个有序链表
 * @Author : sunzhenning
 * @Since : 2022/6/29 10:58
 */
public class NO_21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个保护节点
        ListNode protect = new ListNode(0);
        ListNode protectHead = protect;
        //升序，小的放到前面。注意：两个链表本身就是升序的
        while (list1 != null && list2 !=null){
            if(list1.val > list2.val){
                protectHead.next = list2;
                list2 = list2.next;
            }else{
                protectHead.next = list1;
                list1 = list1.next;
            }
            protectHead = protectHead.next;
        }
        //list1还有没有遍历完成的，list2遍历完成了
        if(list1 != null && list2 == null){
            protectHead.next = list1;
        }
        //list2还有没有遍历完成的，list1遍历完成了
        if(list1 == null && list2 != null){
            protectHead.next = list2;
        }
        return protect.next;
    }


}
