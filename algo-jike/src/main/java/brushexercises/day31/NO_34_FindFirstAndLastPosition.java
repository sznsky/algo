package brushexercises.day31;

import java.util.Arrays;

/**
 * @Describe : leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 * @Author : sunzhenning
 * @Since : 2022/6/29 16:34
 */
public class NO_34_FindFirstAndLastPosition {

    public static void main(String[] args) {
        NO_34_FindFirstAndLastPosition findFirstAndLastPosition = new NO_34_FindFirstAndLastPosition();
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] ans = findFirstAndLastPosition.searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 套用前驱后继的模板
     * >=target 后继（target最小，在后边）
     * <=target 前驱 （target最大，在前边）
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        //后继：目标元素在数字中第一个
        int left = 0;
        int right = nums.length;
        while (left < right){
            //等价于(left+right)/2
            int mid = left +(right-left)/2;
            //大于中取最小
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        ans[0] = right;

        //前驱：目标元素在数字中最后一个
        left = -1;
        right = nums.length-1;
        while(left < right){
            //等价于(right+left+1)/2,向上取整
            int mid = left + (right-left+1)/2;
            //小于中取最大
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        ans[1] = right;
        //无解的情况
        if(ans[0] > ans[1]){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}
