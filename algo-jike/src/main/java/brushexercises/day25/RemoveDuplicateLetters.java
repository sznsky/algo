package brushexercises.day25;

import java.util.Stack;

/**
 * @Describe : leetcode:316. 去除重复字母
 * @Author : sunzhenning
 * @Since : 2022/6/23 9:47
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 思路:单调栈思想，遇到一个字符，比栈顶的小，并且后续的字符串还存在这个字符，
 * 弹出这个字符。这样就保证了越大的重复字符排到小字符的前面，仔细想想
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "bcba";
        RemoveDuplicateLetters letters = new RemoveDuplicateLetters();
        System.out.println(letters.removeDuplicateLetters(s));

    }

    /**
     * 单调栈思想：1.如果待入栈的元素，比栈顶元素小，那么看看这个栈顶元素在后续的字符串中是否存在，如果存在，
     * 就要把这个元素出栈，否则就不是【返回结果的字典序最小】
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char chr = s.charAt(i);
            //如果当前元素本来就在栈里，就跳过,因为题目要求每个元素不能重复，刚好去掉一个
            if(stack.contains(chr)){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > chr && (s.indexOf(stack.peek(),i)!=-1)){
                stack.pop();
            }
            stack.push(chr);
        }
        char[] chars = new char[stack.size()];
        //栈一样可以顺序遍历，再给chars赋值
        for(int i=0;i<stack.size();i++){
            chars[i] = stack.get(i);
        }
        return String.valueOf(chars);
    }

}
