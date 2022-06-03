package week1.task;

import week1.classroom.LargestRectangleInHistogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetcode:85【最大矩形】
 * 考察知识点：单调栈思想
 * 借鉴84题的解决方案，将最大矩形从上到下，每一行只为1的看作矩形
 * 例如：第一行看作矩形，第二行加上第一行看作矩形，第三行加上上面所有的看作矩形
 * 也就是将问题转为84题的问题求解
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        //列的长度，就是高
        int col = matrix.length;
        //行的长度，就是宽
        int row = matrix[0].length;
        int[] heights = new int[row];
        int answer = 0;
        //遍历二维数组:外层表示列，内层表示行
        for(int i= 0;i<col; i++){
            for(int j =0;j<row; j++){
                char height = matrix[i][j];
                if(height == '1'){
                    heights[j] = heights[j] + 1;
                }else{
                    heights[j] = 0;
                }
            }
            answer = Math.max(answer, largestRectangleArea(heights));
        }
        return answer;
    }

    public int largestRectangleArea(int[] heights) {
        //最终的结果，最大矩形面积
        int answer = 0;
        //在原数组的的末尾加一个0的元素,不加这个，最后可能只剩下单调递增的矩形数组，还要计算最大的矩形
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
