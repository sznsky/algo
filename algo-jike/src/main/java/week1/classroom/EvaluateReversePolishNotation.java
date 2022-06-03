package week1.classroom;

import java.util.Stack;

/**
 *
 * tokens = ["2","1","+","3","*"]
 * 9
 * leetcode:150
 * 考察：栈
 * @Describe : 逆波兰表达式
 * @Author : sunzhenning
 * @Since : 2022/5/28 15:17
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation reversePolishNotation = new EvaluateReversePolishNotation();
        //String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = reversePolishNotation.evalRPN(tokens);
        System.out.println(result);

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < tokens.length){
            String token = tokens[i];
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
                int y = stack.pop();
                int x = stack.pop();
                int val = cal(x,y,token);
                stack.push(val);
            }else{
                stack.push(Integer.valueOf(token));
            }
            i++;
        }
        return stack.pop();
    }

    private int cal(int x,int y,String op){
        if("+".equals(op)){
            return x+y;
        }else if("-".equals(op)){
            return x-y;
        }else if("*".equals(op)){
            return x*y;
        }else if("/".equals(op)){
            return x/y;
        }
        return 0;
    }



}
