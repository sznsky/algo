package week1.classroom;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode : 239 【滑动窗口最大值】
 * 考察知识点：单调队列思想
 */
public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] answer = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            deque.push(i);
            if(i >= k-1){
                answer[i-(k-1)] = nums[deque.getFirst()];
            }
        }
        return answer;
    }
}
