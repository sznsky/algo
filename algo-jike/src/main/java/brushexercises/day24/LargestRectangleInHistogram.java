package brushexercises.day24;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Describe :leetcode:84. 柱状图中最大的矩形
 * @Author : sunzhenning
 * @Since : 2022/6/22 18:06
 * 思想：单调栈思想
 * 思路：1.从左往往右遍历，维持一个单调递增的栈
 * 2.如果，出现单调递减的情况，将柱子的宽度累加，循环出栈，用当前柱子的高度*累加宽度的值更新答案
 * 3.及时的更新结果
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[] height = {2,4};
        int ans = largestRectangleInHistogram.largestRectangleArea(height);
        System.out.println(ans);

    }

    public int largestRectangleArea(int[] heights) {
        //将原来柱子数组的个数增加一个0元素。不增加也行。但是最后栈中会存在单调递增的柱子，再去计算可能面积最大值。
        // 给了0，就是单调递减了，保证栈中的柱子都出栈了，同时也计算了最大值。
        heights = Arrays.copyOf(heights,heights.length+1);
        int ans = 0;
        //栈，存放单调递增的柱子
        Stack<Rect> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int currentHeight = heights[i];
            int accumulationWidth = 0;
            //出现单调递减的柱子
            while(!stack.isEmpty() && stack.peek().height > currentHeight){
                //宽度累加，注意，这个变量是for循环内部的，不是全局的
                accumulationWidth = accumulationWidth+stack.peek().width;
                ans = Math.max(ans, stack.peek().height*accumulationWidth);
                //出栈
                stack.pop();
            }
            //柱子入栈操作，上面出栈的操作，累加了宽度，给下面的这柱子使用，最终保持所有的柱子单调递增
            Rect rect = new Rect(currentHeight, accumulationWidth+1);
            stack.push(rect);
        }
        return ans;
    }

    /**
     * 矩形类，构造函数
     */
    class Rect{
        int width;
        int height;
        Rect(int height,int width){
            this.width = width;
            this.height = height;
        }
    }

}
