package brushexercises.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode:78. 子集
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        subsets.subsets(nums);
        System.out.println(Arrays.toString(subsets.ans.toArray()));

    }
    /**
     * 最终结果
     */
    private List<List<Integer>> ans;
    /**
     * 中间结果
     */
    private List<Integer> s;

    /**
     * 思路：对于每个元素，选还是不选的问题，递归解决
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        recur(nums,0);
        return ans;
    }

    /**
     * 递归
     */
    private void recur(int[] nums,int index){
        if(nums.length == index){
            ans.add(new ArrayList<>(s));
            return;
        }
        //不选择，直接递归
        recur(nums, index+1);
        //选择,再去递归
        s.add(nums[index]);
        recur(nums, index+1);
        //还原现场，移除中间结果的值
        s.remove(s.size()-1);
    }

}
