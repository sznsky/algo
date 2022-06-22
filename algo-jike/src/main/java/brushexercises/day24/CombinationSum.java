package brushexercises.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : leetcode:39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 * @Author : sunzhenning
 * @Since : 2022/6/22 10:35
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum.combinationSum(candidates, target);
        System.out.println(Arrays.toString(combinationSum.ans.toArray()));
    }

    //最终结果
    private List<List<Integer>> ans;
    //中间结果
    private List<Integer> ss;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        ss = new ArrayList<>();
        recur(candidates, target, 0);
        return ans;
    }

    private void recur(int[] candidates,int target,int index){
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(ss));
            return;
        }
        //不选择:直接跳过当前数，即跳过candidates[index]
        recur(candidates, target, index+1);
        //选择
        if(target-candidates[index] >=0){
            ss.add(candidates[index]);
            recur(candidates, target-candidates[index], index);
            ss.remove(ss.size()-1);
        }
    }






}
