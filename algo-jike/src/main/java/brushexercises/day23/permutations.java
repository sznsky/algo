package brushexercises.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : leetcode: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @Author : sunzhenning
 * @Since : 2022/6/22 9:53
 * 思路：递归+回溯(内部存在循环，判断是否选择过)
 * 注意:排列和递归的区别
 */
public class permutations {

    public static void main(String[] args) {
        permutations permutations = new permutations();
        int[] nums = {1,2,3};
        permutations.permute(nums);
        System.out.println(Arrays.toString(permutations.ans.toArray()));
    }

    //最终结果
    private List<List<Integer>> ans;
    //中间结果
    private List<Integer> s;
    //记录一个数字是否选择过
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        used = new boolean[nums.length];
        backtrace(nums, 0);
        return ans;
    }

    private void backtrace(int[] nums,int index){
        if(nums.length == index){
            //深拷贝
            ans.add(new ArrayList<>(s));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //如果没有选择过
           if(!used[i]){
               //选择该元素
              s.add( nums[i]);
              //将used[i]置为ture
              used[i] = true;
              //回溯递归
              backtrace(nums,index+1);
              //用完了，给false（还原现场）
              used[i] = false;
              //s用完了，移除（还原现场）
              s.remove(s.size()-1);
           }
        }
    }
}
