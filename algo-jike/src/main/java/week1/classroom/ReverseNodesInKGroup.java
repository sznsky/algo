package week1.classroom;

import comm.ListNode;

/**
 * 1.分组
 * 2.反转
 * 3.反转后的部分原链表的链接
 * @Describe :25
 * @Author : sunzhenning
 * @Since : 2022/6/1 20:47
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        return null;
    }

    public void reverse(ListNode head){
        ListNode last = null;
        while (head != null){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }


    private ListNode divideIntoGroups(ListNode head, int k){
        k = k-1;
        while(head != null){
            if(k == 0){
                return head;
            }
            head = head.next;
            k--;
        }
        return null;
    }

}
