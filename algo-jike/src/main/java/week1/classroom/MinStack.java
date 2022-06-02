package week1.classroom;

import java.util.Stack;

/**
 * leetcode:155 【最小栈】
 *
 */
public class MinStack {
        /**
         * 栈：主容器
         */
        public Stack<Integer> s;
        /**
         * 前置栈：存放历史最小值，比较以后，比较小的值放大栈顶
         */
        private Stack<Integer> preMin;

        /**
         * 构造的函数
         */
        public MinStack() {
            s = new Stack<>();
            preMin = new Stack<>();
        }

        public void push(int val) {
            //1.将数据放到栈中
            s.push(val);
            //2.比较入栈的数据，取出最小的压栈
            if(preMin.isEmpty()){
                preMin.push(val);
            }else{
                //和当前要入栈的数据比较，小的压入前置栈
                if(preMin.peek() > val){
                    preMin.push(val);
                }else{
                    preMin.push(preMin.peek());
                }
            }
        }

        public void pop() {
            s.pop();
            preMin.pop();
        }

        public int top() {
            return s.peek();
        }

        /**
         * 最小值，就是前置栈栈顶的数据
         * @return
         */
        public int getMin() {
            return preMin.peek();
        }

}
