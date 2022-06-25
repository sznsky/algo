package week4.task;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode:239. 滑动窗口最大值
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/23 12:41
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = slidingWindowMaximum.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));
    }


    /**
     * 滑动窗口：单调队列思想解决
     * 1.双端队列的长度和窗口的长度保持一致，不断增加值的过程中，尾部要删除值
     * 2.双端队列维持一个单调递减的队列，队列头部永远是最大的值
     * 3.如果进来的值比队列顶部的值大，出现了单调递增的情况，那么循环和队列中的值，比较，只留大的这一个值。
     * 4.注意刚开始边界的k个数
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        //创建双端队列存放窗口的里面的值的下标i,注意存放的是下标
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            //窗口是不断的向前移动的，存了k个值的下标，要移除开始的值
            while(!deque.isEmpty() && deque.getFirst() <= i-k){
                deque.removeFirst();
            }
            //队列中要维持单调递增的值的下标，出现单调递增的情况，要循环和当前值比较，比当前小的，都删除,维持队列的单调递减
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            //将当前值的下标入队列
            deque.addLast(i);
            //注意滑动窗口是有长度的，刚开始不需要返回,下面的k-1和i-k+1可以画图确定
            if(i>= k-1){
                ans[i-k+1] = nums[deque.getFirst()];
            }
        }
        return ans;
    }

}
