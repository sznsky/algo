package week5.example;

import java.util.*;

/**
 * leetcode:17. 电话号码的字母组合
 */
public class NO_17_LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        NO_17_LetterCombinationsOfAPhoneNumber phoneNumber = new NO_17_LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        phoneNumber.letterCombinations(digits);
        System.out.println(Arrays.toString(phoneNumber.ans.toArray()));
    }

    private Map<Character,String> map = new HashMap<>();
    private String digits;
    private List<String> ans;

    /**
     * 思路：1.创建号码键值对
     * 2.dfs深度遍历，遍历digits，每次遍历选择一个号码对应的字符，和之前的字符串连接起来
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)){
            return new ArrayList<>();
        }
        this.digits = digits;
        ans = new ArrayList<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"xwyz");
        dfs("",0);
        return ans;
    }

    private void dfs(String str,int index){
        if(digits.length() == index){
            ans.add(str);
            return;
        }
        //找到digits数字比如digits=123
        char phoneNum = digits.charAt(index);
        //找到数字对应的英文字母
        String letters = map.get(phoneNum);
        //遍历每个号码对应的字母
        for(char chr : letters.toCharArray()){
            //遍历上个号码的字母和当前字母拼接，递归
            dfs(str+chr,index+1);
        }
    }

}
