package brushexercises.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : leetcode:22. 括号生成
 * @Author : sunzhenning
 * @Since : 2022/6/17 14:38
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
        System.out.println(Arrays.toString(generateParentheses.ans.toArray()));
    }


    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        recur(n, n, n, "");
        return ans;
    }

    /**
     * 思路：1.本地就是左括号和右括号的拼接，但是，拼接必须是成对出现，而且是有效的
     * 2.如果剩余的left=right,说明左括号和右括号是成对出现的，那么下一个必须是左括号
     * 3.如果剩余left<right,那么下一个出现的可以是左括号,也可以是右括号;如：()(,下一个出现可以是左括号()((,也可以是右括号()().
     * 4.递归找出所有的情况
     * 注意：left和right都是递减的，剩余的
     * @param n
     * @param left
     * @param right
     */
    private void recur(int n, int left ,int right,String str){
        //左括号和右括号的数量递减为0，结束
        if(left ==0 && right == 0){
            ans.add(str);
            return;
        }
        //左括号和右括号相等，说明已经成对出现了，下一个只能是左括号
        if(left == right){
            recur(n,left-1,right,str+"(");
        }
        //注意:left和right是递减的，是剩下的，总是左括号先使用。所以left一定是小于等于right
        if(left < right){
            if(left > 0){
                recur(n,left-1,right,str+"(");
            }
            if(right > 0){
                recur(n,left,right-1,str+")");
            }
        }
    }
}
