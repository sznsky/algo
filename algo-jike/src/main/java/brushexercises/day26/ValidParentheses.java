package brushexercises.day26;

import java.util.Stack;

/**
 * @Describe : leetcode:20. 有效的括号
 * @Author : sunzhenning
 * @Since : 2022/6/24 21:18
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "))";
        boolean ans = validParentheses.isValid2(s);
        System.out.println(ans);
    }

    /**
     * 思路：使用栈的思想，先进后出
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //括号个数为单数，不可能完全匹配
        if(s.length() % 2 !=0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char chr = chars[i];
            //左括号入栈
            if('(' == chr || '{' == chr || '[' == chr){
                stack.push(chr);
                continue;
            }
            //如果来的不是左括号，但是栈还是空，说明来的都是右括号，有一点是必须的，最后一个出栈的肯定是左括号。
            if(stack.isEmpty()){
                return false;
            }
            //左括号出栈，左括号和右括号匹配不了
            char leftBracket = stack.pop();
            if((leftBracket == '(' && chr != ')') || (leftBracket == '{' && chr != '}') || (leftBracket == '[' && chr != ']')){
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isValid2(String s) {
        //括号个数为单数，不可能完全匹配
        if(s.length() % 2 !=0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char chr = chars[i];
            //左括号入栈
            if('(' == chr || '{' == chr || '[' == chr){
                stack.push(chr);
            }else{
                //来的是右括号，栈为空，没得匹配。
                if(stack.isEmpty()){
                    return false;
                }
                //来的是右括号，左括号出栈，左括号和右括号匹配不了
                char leftBracket = stack.pop();
                if((leftBracket == '(' && chr != ')') || (leftBracket == '{' && chr != '}') || (leftBracket == '[' && chr != ']')){
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
