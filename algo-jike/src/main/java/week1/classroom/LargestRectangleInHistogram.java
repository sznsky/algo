package week1.classroom;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetcode:84. 【柱状图中最大的矩形】
 * 考察知识点：单调栈思想
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        //最终的结果，最大矩形面积
        int answer = 0;
        //在原数组的的末尾加一个0的元素,不加这个，最后可能只剩下单调递增的矩形，还要计算最大的矩形
        //下面的程序其实就在计算最大的矩形面积
        heights = Arrays.copyOf(heights, heights.length+1);
        //单调栈，存放单调递增的矩形
        Stack<Rect> rectStack = new Stack<>();
        //遍历给定的矩形数组
        for(int i=0;i< heights.length; i++){
            //当前矩形的高度
            int currentHeight = heights[i];
            //累加宽度
            int accumulationWidth = 0;
            //当前矩形的高度小于（栈顶）存放的
            while(!rectStack.isEmpty() && currentHeight < rectStack.peek().height){
                accumulationWidth += rectStack.peek().width;
                answer = Math.max(answer, rectStack.peek().height * accumulationWidth);
                //逐个出栈
                rectStack.pop();
            }
            //存放单调矩形
            Rect rect = new Rect(currentHeight,accumulationWidth+1);
            rectStack.push(rect);
        }
        return answer;
    }


    /**
     * 内部类，存放矩形的宽度和高度
     */
    class Rect {
        private int height;
        public int width;
        Rect(int height,int width){
            this.height = height;
            this.width = width;
        }
    }

}
