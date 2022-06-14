package brushexercises.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe :leetcode:46. 全排列
 * @Author : sunzhenning
 * @Since : 2022/6/14 16:37
 * 思路:1.递归，对于同一个数选择还是不选择
 * 2.需要维护一个boolean数组和nums对应起来，表示这个元素是否选择
 * 3.维护一个结果数组，中间结果数组
 * 4.注意边界
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1,2,3};
        p.permute(nums);
        System.out.println(Arrays.asList(p.ans.toArray()));
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
     *存放nums元素是否被选择过，注意及时还原现场
     */
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        used = new boolean[nums.length];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums,int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(s));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //没有选择过nums[i]
            if(!used[i]){
                //选择
                s.add(nums[i]);
                used[i] = true;
                recur(nums,index+1);
                //还原
                s.remove(s.size()-1);
                used[i] = false;
            }
        }
    }

}
