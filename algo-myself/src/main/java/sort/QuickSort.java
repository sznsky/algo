package sort;

import java.util.Arrays;

/**
 * @Describe : 快速排序
 * @Author : sunzhenning
 * @Since : 2022/5/25 17:23
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,6,9,2,5,3,7,2,4,8,-1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start < end){
            //选择基准，也可以随机选择
            int base = arr[start];
            int low = start;
            int high = end;
            while (low < high){
                while (low < high && arr[high] >= base){
                    high --;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= base){
                    low ++;
                }
                arr[high] = arr[low];
            }
            //
            arr[low] = base;
            arr[high] = base;
            quickSort(arr, start,low);
            quickSort(arr, low+1,end);
        }
    }
}
