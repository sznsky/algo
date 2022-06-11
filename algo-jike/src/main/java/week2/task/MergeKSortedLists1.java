package week2.task;

import comm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Describe : leetcode:23【合并K个升序链表】
 * @Author : sunzhenning
 * @Since : 2022/6/9 3:39
 */
public class MergeKSortedLists1 {

    /**
     * 使用分治合并解法：
     * 思路:1.判断边界
     * 2.将链表数组按照一定的规则，分成两个。变成两个链表
     * 3.将两个按照值的大小顺序合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        ListNode a = merge(lists, start, mid);
        ListNode b = merge(lists, mid + 1, end);
        return mergeTwoNodeList(a, b);
    }

    /**
     * 合并两个链表
     */
    public ListNode mergeTwoNodeList(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = new ListNode(0);
        //这个变量就是把下面比较小的数值依次往tail后面接
        ListNode tail = head;
        ListNode tempA = a;
        ListNode tempB = b;
        while (tempA != null && tempB != null) {
            if (tempA.val > tempB.val) {
                tail.next = tempB;
            } else {
                tail.next = tempA;
            }
            tail = tail.next;
        }
        return head.next;
    }
}
