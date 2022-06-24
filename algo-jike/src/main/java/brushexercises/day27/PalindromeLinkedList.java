package brushexercises.day27;

import comm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe : leetcode:234. 回文链表
 * @Author : sunzhenning
 * @Since : 2022/6/25 3:16
 */
public class PalindromeLinkedList {

    /**
     * 思路：1.将链表遍历，将值存放到数组中
     * 2.判断数组是否是回文数组
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return isPalindromeArray(list);
    }

    /**
     * 判断数组(集合)是否是回文数组
     * @param list
     * @return
     */
    public boolean isPalindromeArray(List<Integer> list) {
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i) != list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }


}
