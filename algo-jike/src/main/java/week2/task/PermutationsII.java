package week2.task;

import week2.classroom.Permutations;

import java.util.*;

/**
 * 全排列2
 * leetcode:47. 全排列 II
 * 思路:递归，使用set集合，加入答案的时候，判断是否存在了
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        int[] nums = {1,1,3};
        System.out.println(Arrays.toString(permutations.permuteUnique(nums).toArray()));
    }

    private List<List<Integer>> ans;
    private List<Integer> s;
    private boolean[] used;
    private Set<String> set;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        used = new boolean[nums.length];
        set = new HashSet<>();
        recur(nums,0);
        return ans;
    }

    private void recur(int[] nums,int index){
        if(index == nums.length){
            //存放结果的时候，判断是否已经存在了
            String key = Arrays.toString(s.toArray());
            if(!set.contains(key)){
                set.add(key);
                ans.add(new ArrayList<>(s));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                s.add(nums[i]);
                used[i] = true;
                recur(nums, index+1);
                used[i] = false;
                s.remove(s.size()-1);
            }
        }
    }

}
