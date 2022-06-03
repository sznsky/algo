package brushexercises.day5;

import java.util.Stack;

/**
 * leecode:20 【有效的括号】
 * 知识点：栈
 */
public class ValidParentheses {

    /**
     * 思路：
     * 1.遍历字符串的字符
     * 2.左括号入栈，遇到右括号，栈顶弹出左括号，与右括号匹配，如果匹配不成功，直接返回false
     * 3.遍历完成，返回true
     * 4.注意：1）单数长度的字符串，false
     *        2)如果遍历完成，还有字符串没有出栈，说明里面存的都是左括号，没有与之对应的右括号，false
     *        3)如果右括号来了，每次出栈左括号的时候，判断一下栈是否为空，为空，false.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if(chars.length % 2 !=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            char chr = chars[i];
            if(chr == '(' || chr == '{' || chr == '['){
                stack.push(chr);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                //左括号出栈
                char leftBracket = stack.pop();
                if(leftBracket == '(' && chr != ')'){
                    return false;
                }else if(leftBracket == '{' && chr != '}'){
                    return false;
                }else if(leftBracket == '[' && chr != ']'){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }



}
