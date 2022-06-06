package week1.classroom;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode : 239 【滑动窗口最大值】
 * 考察知识点：单调队列思想
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }


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
            deque.addLast(i);
            if(i >= k-1){
                answer[i-(k-1)] = nums[deque.getFirst()];
            }
        }
        return answer;
    }
}
