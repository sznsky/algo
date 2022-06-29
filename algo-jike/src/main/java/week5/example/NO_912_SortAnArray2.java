package week5.example;

import java.util.Arrays;

/**
 * leetcode:912. 排序数组-快速排序
 */
public class NO_912_SortAnArray2 {

    public static void main(String[] args) {
        NO_912_SortAnArray2 sortAnArray2 = new NO_912_SortAnArray2();
        int[] nums = {5,1,1,2,0,0};
        sortAnArray2.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序：分治思想+递归
     * 注意：区别归并排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    /**
     * 找到中轴，递归
     * @param nums
     * @param left
     * @param right
     */
    void quickSort(int[] nums,int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition(nums,left,right);
        quickSort(nums,left,pivot);
        quickSort(nums,pivot+1,right);
    }

    int partition(int[] nums,int left,int right){
        //随机选择中轴
        int pivot = left + (int)Math.random()%(right - left +1);
        int pivotVal = nums[pivot];
        while(left <= right){
            while (nums[left] < pivotVal){
                left ++;
            }
            while (nums[right] > pivotVal){
                right --;
            }
            if(left == right){
                break;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return right;
    }


}
