package brushexercises.day30;

import comm.ListNode;

/**
 * @Describe : leetcode：160. 相交链表
 * @Author : sunzhenning
 * @Since : 2022/6/28 16:55
 */
public class NO_160_IntersectionOfTwoLinkedLists {

    /**
     * 1.我走你走过的路，发现你也在走我走过的路
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            if(a != null){
                a = a.next;
            }else{
                a = headB;
            }
            if(b != null){
                b = b.next;
            }else{
                b = headA;
            }
        }
        return a;
    }

}
