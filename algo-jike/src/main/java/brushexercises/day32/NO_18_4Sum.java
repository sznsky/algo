package brushexercises.day32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe :18. 四数之和
 * @Author : sunzhenning
 * @Since : 2022/6/30 16:24
 */
public class NO_18_4Sum {

    public static void main(String[] args) {
        NO_18_4Sum sum = new NO_18_4Sum();
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        List<List<Integer>> ans = sum.fourSum(nums,target);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return ans;
        }
        int length = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target - nums[i+1] -nums[i+2] + nums[i+3]){
                break;
            }
            if(nums[i] < target - nums[length -1] - nums[length-2] - nums[length-3]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if(nums[i] > target - nums[j] -nums[j+1] - nums[j+2]){
                    break;
                }
                if(nums[i] < target - nums[j] - nums[length-1] - nums[length-2]){
                    continue;
                }
                int left = j+1,right = length-1;
                while (left < right){
                    if(nums[i] + nums[j] -target < - (nums[left] + nums[right])){
                        left ++;
                    }else if(nums[i] + nums[j] -target > - (nums[left] + nums[right])){
                        right --;
                    }else{
                        List<Integer> s = new ArrayList<>();
                        s.add(nums[i]);
                        s.add(nums[j]);
                        s.add(nums[left]);
                        s.add(nums[right]);
                        ans.add(s);
                        while (left < right && nums[left] == nums[left+1]){
                            left ++;
                        }
                        left ++;
                        while (left < right && nums[right] == nums[right-1]){
                            right --;
                        }
                        right --;
                    }
                }
            }
        }
        return ans;
    }
}
