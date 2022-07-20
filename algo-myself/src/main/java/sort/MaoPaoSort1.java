package sort;

import java.util.Arrays;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/20 18:24
 */
public class MaoPaoSort1 {


    public static void main(String[] args) {
        int[] nums = {6,3,2,5,6,7,9,3,1};
        System.out.println(Arrays.toString(sort(nums)));
    }

    public static int[] sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
