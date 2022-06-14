package brushexercises.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : 组合 leetcode:77
 * @Author : sunzhenning
 * @Since : 2022/6/14 13:45
 * 思路：1.递归，每个数选择还是不选择
 * 2.判断边界
 * 3.存放最终结果和中间结果的成员变量
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        int n = 1;
        int k = 1;
        combinations.combine(n,k);
        System.out.println(Arrays.toString(combinations.ans.toArray()));

    }
    //存放最终结果的
    private List<List<Integer>> ans;
    //存放中间结果
    private List<Integer> s;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        recur(1, n, k);
        return ans;
    }

    /**
     * 递归：对于一个数，选择还是不选择
     * 选择就放到s中（存储中间结果）
     * @param n n个数
     * @param k k个数
     */
    private void recur(int index,int n, int k){
        //找到k个数，退出
        if(s.size() == k){
            ans.add(new ArrayList<>(s));
            return;
        }
        //index大于n或者不足k个数了
        if(index > n || n-index < k){
            return;
        }
        //不选择，进入下一次递归
        recur(index+1, n, k);
        //选择当前数，然后进入下一次递归
        s.add(index);
        recur(index+1, n, k);
        //还原现场
        s.remove(s.size()-1);
    }





}
