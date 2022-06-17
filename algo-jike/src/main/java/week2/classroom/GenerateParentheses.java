package week2.classroom;

import java.util.*;

/**
 * leetcode:22. 括号生成
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> list = generateParentheses.generateParenthesis(3);
        System.out.println(Arrays.toString(list.toArray()));

    }

    private Map<Integer,List<String>> store = new HashMap<>();

    /**
     * 思路：分治算法，分成(a)b这两种，a是嵌套的括号，b是独立的括号
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            ans.add("");
            return ans;
        }
        //将结果存储起来
        if(store.get(n)!=null){
            return store.get(n);
        }
        for(int k=1;k<=n;k++){
            System.out.println("==================K:"+k+",n:"+n);
            List<String> aList = generateParenthesis(k-1);
            List<String> bList = generateParenthesis(n-k);
            for(String a: aList){
                System.out.println("a:"+a);
                for(String b: bList){
                    System.out.println("b:"+b);
                    ans.add("("+a+")"+b);
                    System.out.println("("+a+")"+b);
                }
            }
        }
        store.put(n,ans);
        return ans;
    }
}
