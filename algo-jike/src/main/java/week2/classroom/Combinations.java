package week2.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : 组合 leetcode:77
 * @Author : sunzhenning
 * @Since : 2022/6/7 18:09
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 思路：递归算法
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations combinations = new Combinations();
        combinations.combine(n,k);
        System.out.println(Arrays.toString(combinations.ans.toArray()));
    }

    //n个数
    private int n;
    //取k个数
    private int k;
    //最终结果
    private List<List<Integer>> ans;
    //局部结果:每次递归选择中的
    private List<Integer> chosen;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        ans = new ArrayList<>();
        chosen = new ArrayList<>();
        //从1开始
        recur(1);
        return ans;
    }

    private void recur(int i){
        //退出条件：//本次递归结束，只取k个元素的数组，多个不要，或者剩下不足k个元素
        if(chosen.size() > k || chosen.size()+n-i+1 < k){
            return;
        }
        //到头了,i从1开始的，需要到n+1才出界了，才退出
        if(i == n+1){
            ans.add(new ArrayList<>(chosen));
            return;
        }

        //每一个数字，要么选择，要么不选择，两种情况,向下传递参数，所以index+1
        //1.不选择该数字nums[index]
        recur(i+1);
        //2.选择该数字nums[index]
        chosen.add(i);
        recur(i+1);
        //3.还原现场
        chosen.remove(chosen.size()-1);
    }




}
