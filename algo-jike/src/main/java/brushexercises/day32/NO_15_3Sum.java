package brushexercises.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe : 15. 三数之和
 * @Author : sunzhenning
 * @Since : 2022/6/30 20:10
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class NO_15_3Sum {

    public static void main(String[] args) {
        NO_15_3Sum sum = new NO_15_3Sum();
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> ans = sum.threeSum(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    /**
     * 三数之和，思路：
     * 1.排序
     * 2.遍历nums,当nums[i]时候，开辟两个指针，l = i+1,right = length-1.
     * 2.遍历的过程中，当nums[i]>0时，无论左右指针无论怎么移动，三数之和只能大于0。如果nums[i]+nums[l]+nums[r]>0,r--;nums[i]+nums[l]+nums[r]<0,l++
     * 3.nums[i]=0时候，记录结果。同时nums[l]=nums[l+1]去重，l++;nums[r]=nums[r-1]去重,r--;
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            //去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left < right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    List<Integer> s = new ArrayList<>();
                    s.add(nums[i]);
                    s.add(nums[left]);
                    s.add(nums[right]);
                    ans.add(s);
                    //去重
                    while (left < right && nums[left] == nums[left +1]){
                        left++;
                    }
                    //去重
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right] > 0){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return ans;
    }

}
