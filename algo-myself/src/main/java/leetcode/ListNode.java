package leetcode;

/**
 * 自定义一个链表类
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/5/26 18:07
 */
public class ListNode {
    /**
     * 链表存的值
     */
    int val;
    /**
     * 下个节点的指针
     */
    ListNode next;

    /**
     * 构造方法
     * @param x
     */
    ListNode(int x){
        val = x;
    }

    /**
     * 添加链表对象
     * @param newVal
     */
    public void add(int newVal){
        ListNode newNode = new ListNode(newVal);
        if(this.next == null){
            this.next = newNode;
        }else{
            this.add(newVal);
        }
    }

    /**
     * 打印链表
     */
    public void print(){
        System.out.println(this.val);
        if(this.next != null){
            System.out.println("-->");
            this.next.print();
        }
    }
}
