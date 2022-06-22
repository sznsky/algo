package brushexercises.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : leetcode:78. 子集
 * @Author : sunzhenning
 * @Since : 2022/6/22 10:19
 * 思路：本题是个组合问题，注意排列的区别
 * 组合本质是选择还是不选择的问题，排列本质是排序的问题
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        subsets.subsets(nums);
        System.out.println(Arrays.toString(subsets.ans.toArray()));
    }


    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        recur(nums,0);
        return ans;
    }
    //最终答案
    private List<List<Integer>> ans;
    //中间答案
    private List<Integer> s;
    /**
     * 循环递归:本质还是选择的问题
     * 注意：虚线哪个是一起的
     */
    private void recur(int[] nums,int index){
        //一轮走完了，要结束了
        if(nums.length == index){
            ans.add(new ArrayList<>(s));
            return;
        }
        //不选择该元素,直接加入下一个递归============start=============
        recur(nums, index+1);
        //========================================end=============
        //选择该元素,然后进入下一次循环============start=============
        s.add(nums[index]);
        recur(nums, index+1);
        //还原现场
        s.remove(s.size()-1);
        //========================================end=============
    }

}
