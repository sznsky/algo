package comm;

/**
 * @Describe : 链表类
 * @Author : sunzhenning
 * @Since : 2022/5/31 14:26
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
