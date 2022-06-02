package week1.classroom;

import java.util.Stack;

/**
 * leetcode:20【有效的括号】
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = ")(";
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid(s);
        System.out.println(result);
    }

    /**
     * 思路：
     * 1.将左括号入栈，多个左括号，连续入栈
     * 2.遇到右括号时候，将栈顶的左括号弹出，和这个右括号匹配
     * 3.匹配不成功，直接返回错误。如果匹配成功，继续匹配下一个，只要有个不成功，返回false,直到所有的左括号出栈,才返回true
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(n%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0 ;i<n; i++){
            char chr = chars[i];
            if('(' == chr || '{' == chr || '[' == chr){
                //压栈
                stack.push(chr);
            }else{
                //注意1：如果一个进来的是右括号，直接false,因为右括号不能放到左边
                if(stack.isEmpty()){
                    return false;
                }
                //弹出最上面的符号
                char left = stack.pop();
                if(left == '(' && chr != ')'){
                    return false;
                }
                if(left == '{' && chr != '}'){
                    return false;
                }
                if(left == '[' && chr != ']'){
                    return false;
                }
            }
        }
        //注意2：如果全部是左括号，没有出栈机会，也不行
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
