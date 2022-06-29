package week5.example;

import java.util.Arrays;

/**
 * leetcode:912. 排序数组-计数排序
 */
public class NO_912_SortAnArray3 {

    public static void main(String[] args) {
        NO_912_SortAnArray3 sortAnArray3 = new NO_912_SortAnArray3();
        int[] nums = {3,-1};
        int[] ans = sortAnArray3.sortArray(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 计数排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        //结果
        int[] ans = new int[nums.length];
        //结果的指针
        int n = 0;
        int[] count = new int[100001];
        //计数
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        //扫描，遍历结果
        for(int val =0;val<=100000;val++){
            while (count[val] > 0){
                count[val] --;
                ans[n] = val;
                n++;
            }
        }
        return ans;
    }

}
