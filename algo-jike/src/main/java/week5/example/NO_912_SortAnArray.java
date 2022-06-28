package week5.example;

import java.util.Arrays;

/**
 * leetcode:912. 排序数组-冒泡排序
 */
public class NO_912_SortAnArray {

    public static void main(String[] args) {
        NO_912_SortAnArray sortAnArray = new NO_912_SortAnArray();
        int[] nums = {5,2,3,1};
        int[] ans  = sortAnArray.sortArrayOfBubble1(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 使用java类库：底层还是快速排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public int[] sortArrayOfBubble(int[] nums) {
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
    /**
     * 冒泡排序1
     * @param nums
     * @return
     */
    public int[] sortArrayOfBubble1(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

}
