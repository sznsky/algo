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
        //单调队列，使用双端队列-链表实现，存放的是单调递减nums[i]的下标，如果遇到单调递增的nums[i],则和该队列中其他的元素，对比，删除不符合单调递增nums[i]的下标
        Deque<Integer> deque = new LinkedList<>();
        //结果：注意长度要减去k再加1
        int[] answer = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            //窗口在不停的向前移动，窗口只能存放k个数字，因此队列deque最多只能存k个数字的下标，因此不停的删除队列首位的元素
            while(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.removeFirst();
            }
            //queue存放的单调递减的nums[i]的下标i。出现递增的num[i],则循环删除queue对应的nums[i],直到单调递增。
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            //将nums[i]中的i加入到queue
            deque.addLast(i);
            //注意，窗口是有长度的移动，刚开始不需要返回
            if(i >= k-1){
                //依次更新答案，由于queue维护的单调递减nums[i]的i,因此queue头部值对应的nums[i]就是最大值
                answer[i-(k-1)] = nums[deque.getFirst()];
            }
        }
        return answer;
    }
}
