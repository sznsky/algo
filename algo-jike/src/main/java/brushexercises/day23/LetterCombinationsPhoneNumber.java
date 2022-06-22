package brushexercises.day23;

import java.util.*;

/**
 * @Describe :17. 电话号码的字母组合
 * @Author : sunzhenning
 * @Since : 2022/6/22 9:07
 * 思路：回溯和递归
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        String digits = "234";
        List<String> ans = letterCombinationsPhoneNumber.letterCombinations(digits);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)){
            return new ArrayList<>();
        }
        Map<Character,String> phoneNumMap = new HashMap<>();
        phoneNumMap.put('2',"abc");
        phoneNumMap.put('3',"def");
        phoneNumMap.put('4',"ghi");
        phoneNumMap.put('5',"jkl");
        phoneNumMap.put('6',"mno");
        phoneNumMap.put('7',"qprs");
        phoneNumMap.put('8',"tuv");
        phoneNumMap.put('9',"wxyz");
        //最终结果
        List<String> ans = new ArrayList<>();
        //中间结果
        StringBuilder s = new StringBuilder();
        //回溯调用
        backtrack(digits, phoneNumMap, 0, ans,s);
        return ans;
    }

    /**
     * 回溯算法：本质上一个穷举的算法
     * @param digits
     * @param phoneNumMap
     * @param index
     * @param ans
     * @param s
     */
    private void backtrack(String digits,Map<Character,String> phoneNumMap,Integer index,List<String> ans,StringBuilder s){
        if(s.length() == digits.length()){
            ans.add(s.toString());
            return;
        }
        //找到单个数字字符，比如digit是”23“，那么chr是2
        char chr = digits.charAt(index);
        //取到字母串
        String letters = phoneNumMap.get(chr);
        //先是遍历外层的，再一层层嵌套遍历
        for(int i=0;i<letters.length();i++) {
            char letter = letters.charAt(i);
            //凭借字符串
            s.append(letter);
            //递归回溯
            backtrack(digits,phoneNumMap,index+1, ans, s);
            //s为临时结果存放的变量，删除s最外层的值，每次递归完成，相当于还原现场
            s.deleteCharAt(index);
        }
    }

}
