package brushexercises.day6;

import comm.ListNode;

public class ReverseNodesInKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        //链表的保护节点
        ListNode entry = new ListNode();
        entry.next = head;
        ListNode last = entry;
        while (head != null) {
            //分组，获取当前组最后一个节点
            ListNode tail = getEnd(head, k);
            if (tail == null) {
                break;
            }
            //下一个组开始的节点
            ListNode nextHead = tail.next;
            //组内反转
            reverseList(head, nextHead);

            last.next = tail;
            last = head;
            head = nextHead;
        }
        last.next = head;
        return entry.next;
    }

    //分组，获取本组最后一个节点
    private ListNode getEnd(ListNode head, int k) {
        //k个一组，只需往后走k-1步
        k = k - 1;
        while (head != null) {
            if (k == 0) return head;
            head = head.next;
            k--;
        }
        return null;
    }

    // 组的内部反转
    private void reverseList(ListNode head, ListNode stop) {
        ListNode now = head.next;
        ListNode last = head;
        // 遍历
        while (now != stop) {
            // 备份now.next
            ListNode next = now.next;
            // 操作：now指向last
            now.next = last;
            // 往后移动
            last = now;
            now = next;
        }
    }

}
