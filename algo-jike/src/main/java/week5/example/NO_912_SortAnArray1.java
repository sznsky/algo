package week5.example;

import java.util.Arrays;

/**
 * leetcode:912. 排序数组-归并排序
 * 思路:使用归并排序
 */
public class NO_912_SortAnArray1 {
    public static void main(String[] args) {
        NO_912_SortAnArray1 sortAnArray1 = new NO_912_SortAnArray1();
        int[] nums = {-2,3,-5};
        sortAnArray1.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：使用归并排序，基于分治算法的排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    /**
     * 分治算法+递归
     */
    private void mergeSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left ,mid, right);
    }

    /**
     * 合并
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arr,int left,int mid, int right){
        //创建一个临时数组，存放合并后的
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        for(int k=0;k<temp.length;k++){
            //j>right说明右半部分数组都已经存完了,都已经存到temp中
            if(j>right || (i<= mid && arr[i] <= arr[j])){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
        }
        //拷贝回原数组
        for(int k=0;k<temp.length;k++){
            arr[left + k] = temp[k];
        }
    }

}
