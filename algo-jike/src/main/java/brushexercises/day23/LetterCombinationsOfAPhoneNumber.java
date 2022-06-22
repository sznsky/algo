package brushexercises.day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode:17. 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        Map<Character,String> phoneMap = new HashMap<Character,String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(ans, phoneMap, digits, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(List<String> combinations, Map<Character,String> phoneMap,
                           String digits,int index,StringBuilder combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for(int i=0;i<lettersCount;i++){
                //拼接结果
                combination.append(letters.charAt(i));
                //回溯
                backtrack(combinations, phoneMap, digits, index+1, combination);
                //还原现场
                combination.deleteCharAt(index);
            }
        }
    }

}
