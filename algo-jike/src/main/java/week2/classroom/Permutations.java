package week2.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe :leetcode:46. 全排列
 * @Author : sunzhenning
 * @Since : 2022/6/9 14:09
 */
public class Permutations {
    private List<List<Integer>> ans;
    private List<Integer> s;
    private boolean[] used;

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(permutations.permute(nums).toArray()));
    }

    /**
     * 思路：递归思想
     * 1.创建ans存放结果数组，s存放每一组结果数组（s是ans的元素），used存放每个元素是否选择的数组(初始化都为false)
     * 2.确定推出边界，index=n的时候，要推出。index=0开始，n-1是最后一个元素
     * 3.循环数组，将nums[i]加入到s中，同时used[i]置为true.就行下次递归，完了以后，将used[i]还原false,将s中移除
     * 4.最后返回结果
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        s = new ArrayList<>();
        used = new boolean[nums.length];
        recur(nums, 0);
        return ans;
    }

    /**
     * 递归
     */
    private void recur(int[] nums,int index){
        if(index == nums.length){
            //千万要注意不要这样写：ans.add(s);这个是浅拷贝，ans引用了s对象，当s对象改变时候，ans对象就没有了。
            //深拷贝
            ans.add(new ArrayList<>(s));
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
