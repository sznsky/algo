package brushexercises.day17;

import java.util.Arrays;

/**
 * leetcode:977. 有序数组的平方
 * @Describe :给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * nums = [-4,-1,0,3,10]
 * @Author : sunzhenning
 * @Since : 2022/6/15 18:03
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray squares = new SquaresOfASortedArray();
        int[] nums = {-7,-3,2,3,11};
        int[] ans = squares.sortedSquares1(nums);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 常规朴素解法：遍历，平方，排序
     * 时间复杂度就是O(nlogn)，除了遍历一次，还排序了一次
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            ans[i] = x*x;
        }
        Arrays.sort(ans);
        return ans;
    }

    /**
     * 思路：1.数组是升序的，可能包含负数，那么，数字的平方最大值，只可能是数组的收尾两端产生。
     * 2。两个指针left和right，放到数组的左右两端
     * 3.（1）创建一个结果数组ans,如果(nums[left])^2 > (nums[right])^2，则将(nums[left])^2 存入到ans末尾，left++
     * （2）否则(nums[right)^2 存入到ans末尾,right--
     * (3)当left==right结束
     * 目的：减少了一次排序，时间复杂度O(n)
     * @param nums
     * @return
     */
    public int[] sortedSquares1(int[] nums) {
        //注意结果数组的长度是nums.length不是nums.length-1
        int[] ans = new int[nums.length];
        //答案指针
        int index = nums.length-1;
        //左指针
        int left = 0;
        //右指针
        int right = nums.length-1;
        while (left <= right){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                ans[index] = nums[left]*nums[left];
                left ++;
            }else{
                ans[index] = nums[right]*nums[right];
                right --;
            }
            index--;
        }
        return ans;
    }



}
