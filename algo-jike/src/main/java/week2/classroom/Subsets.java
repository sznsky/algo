package week2.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : leetcode:78 【子集 】
 * @Author : sunzhenning
 * @Since : 2022/6/7 8:57
 * 思路：递归算法
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
    //最终答案
    private List<List<Integer>> ans;
    //局部答案
    private List<Integer> s;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        recursion(nums,0);
        return ans;
    }

    private void recursion(int[] nums,int index){
        if(index == nums.length){
            //ans.add(s);//浅拷贝，如果s后续被修改，会影响最终结果
            //深拷贝
            ans.add(new ArrayList<>(s));
            return;
        }
        //递归调用：不选当前数组为下标index的值
        recursion(nums, index+1);
        //递归调用：选择当前index的值
        s.add(nums[index]);
        recursion(nums, index+1);
        //还原现场，将上一步选择去掉
        s.remove(s.size()-1);
    }

}
