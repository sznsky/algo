package brushexercises.day29;

import java.util.*;

/**
 * @Describe :leetcode:239. 滑动窗口最大值
 * @Author : sunzhenning
 * @Since : 2022/6/27 15:09
 */
public class NO_239_SlidingWindowMaximum {

    public static void main(String[] args) {
        NO_239_SlidingWindowMaximum slidingWindowMaximum = new NO_239_SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = slidingWindowMaximum.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));

    }

    /**
     * 思想：单调队列思想，维持一个单调递减的队列，队列存放nums的下标，保证队列头部的数最大，头部的下标出列，对应找到值,存入数组，就是最终答案
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            //队列只放k个值的下标，不断的向前移动，必然有头部的数组需要出列
            while(!deque.isEmpty() && deque.getFirst() <= i-k) {
                deque.removeFirst();
            }
            //保持队列下标对应的值单调递减,不是单调递减，remove最后一个
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            //从尾部添加元素，注意;push从头部添加元素
            deque.addLast(i);
            //滑动窗口是有长度的
            if(i >= k-1){
                ans[i-k+1] = nums[deque.getFirst()];
            }
        }
        return ans;
    }

}
