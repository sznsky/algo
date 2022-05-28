package sort;

import java.util.Arrays;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/5/25 17:01
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        int[] nums = {7,2,3,11,5,6,2,1};
        int[] sortNums = sort(nums);
        System.out.println(Arrays.toString(sortNums));
    }

    /**
     * 简单的冒泡排序
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int a = nums[i];
                int b = nums[j];
                if(a > b){
                    nums[i] = b;
                    nums[j] = a;
                }
            }
        }
        return nums;
    }
}
