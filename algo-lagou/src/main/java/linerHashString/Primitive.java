package linerHashString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe : 原语
 * @Author : sunzhenning
 * @Since : 2022/5/25 10:35
 */
public class Primitive {

    public static void main(String[] args) {
        Primitive primitive = new Primitive();
        String s = "()()";
        String s1 = "(())()";
        String s2 = "(())(()(()))";
        System.out.println(primitive.removeOuterParentheses(s));
        System.out.println(primitive.removeOuterParentheses(s1));
        System.out.println(primitive.removeOuterParentheses(s2));
    }



    /**
     * 常规解法：思路
     *  *         //1.将字符串分为多个原语
     *  *         //1.1记录左括号次数，右括号次数，新的原语开始的指针
     *  *         //1.2原语的边界问题
     *  *         //2.将多个原语拼接在一起，然后去掉外层括号。
     * @return
     */
    public String removeOuterParentheses(String s){
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int startNew = 0;
        for(int i=0;i<s.length();i++){
            char chr = s.charAt(i);
            if(chr == '('){
                left ++;
            }else if(chr == ')'){
                right ++;
            }
            if(left == right){
                String str = s.substring(startNew,i+1);
                startNew = i+1;
                list.add(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String str:list){
            String subStr = str.substring(1,str.length()-1);
            stringBuilder.append(subStr);
        }
        return stringBuilder.toString();
    }
}
