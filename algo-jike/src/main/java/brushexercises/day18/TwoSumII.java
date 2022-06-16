package brushexercises.day18;

import java.util.Arrays;

/**
 * @Describe : leetcode:167. 两数之和 II - 输入有序数组
 * @Author : sunzhenning
 * @Since : 2022/6/16 14:33
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * numbers = [2,7,11,15], target = 9
 */
public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSumII.twoSum1(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 思路：既然是有序的数组，使用双指针（对撞指针）
     * 1.left指针放在数组头，right放到数组尾。
     * 2.如果numbers[left]+numbers[right] > target,说明相加的值大了，left不动，right--（注意：单调递增的数组）
     * 3.如果numbers[left]+numbers[right] < target,说明相加的值小了，left++，right不动（注意：单调递增的数组）
     * 4.如果numbers[left]+numbers[right] == target,说明找到答案了，结束
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            if(numbers[left] + numbers[right] > target){
                right --;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
        }
        return ans;
    }



    /**
     * 暴力解法：两层循环，找出结果
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}
