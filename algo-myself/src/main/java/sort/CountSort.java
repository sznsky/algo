package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describe : 计数排序:计数排序的前提是知道数的范围，所以计数排序具有局限性
 * 时间复杂度：O(n+k),其中n表示要排序的个数，k表示数据的范围，排序稳定
 * @Author : sunzhenning
 * @Since : 2022/7/21 17:50
 */
public class CountSort {

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] nums = {6, 3, 7, 5, 3, 2, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        //必须要确定范围：这个就是计数排序的局限性
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        //定义一个计数数组
        int[] countArr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            //计数：比如{1,0,3,3},那么countArr[0]的值就是1，countArr[1]的值就是1，countArr[3]的值就是2
            countArr[nums[i]]++;
        }
        //将计数数组遍历，得到
        int n = 0;
        for(int i=0;i<countArr.length;i++){
            if(countArr[i] == 0) {
                continue;
            }
            while (countArr[i] > 0){
                nums[n] = i;
                n++;
                countArr[i]--;
            }
        }
    }
}
