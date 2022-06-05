package brushexercises.day7;

import java.util.Stack;

/**
 * leetcode:155 【最小栈】
 * 思路：1.通过入栈的时候，记录一个变量min，取出变量最小值。但是出栈的时候，就找不到了。
 * 2.记录最小的值的前置栈，push时候，和栈顶的元素比较，pop的时候，前置栈也跟着pop.
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        //主栈，存储数据的
        stack = new Stack<>();
        //维护一个历史最小值，也就是前置的最小值栈
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
            return;
        }
        //最小栈的栈顶数据和当前存入的数据比较，取最小值
        Integer min = Math.min(minStack.peek(), val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }

}
