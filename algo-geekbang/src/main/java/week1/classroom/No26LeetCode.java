package week1.classroom;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * i=0 n=0 n++
 * [0,0,1,1,1,2,2,3,3,4]
 * i=1 n=1
 * [0,0,1,1,1,2,2,3,3,4]
 * i=2 n=1 n++
 * [0,1,1,1,1,2,2,3,3,4]
 * i=3 n=2
 * [0,1,1,1,1,2,2,3,3,4]
 * i=4 n=2
 * [0,1,1,1,1,2,2,3,3,4]
 * i=5 n=2 n++
 * [0,1,2,1,1,2,2,3,3,4]
 * i=6 n=3
 * [0,1,2,1,1,2,2,3,3,4]
 * i=7 n=3 n++
 * [0,1,2,3,1,2,2,3,3,4]
 * i=8 n=4
 * [0,1,2,3,1,2,2,3,3,4]
 * i=9 n=4 n++
 * [0,1,2,3,4,2,2,3,3,4]
 * i=10 n=5
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。
 * 不需要考虑数组中超出新长度后面的元素。
 */
public class No26LeetCode {

    /**
     * 解题思路：保序、可以使用filter思想（模板）。注意只能原地修改，不能开启额外的数组。
     * 1.数组是连续的存储空间，根据第一个元素的地址，加上某元素的下标，可以访问到任何一个元素。查询的时间复杂度是O(1)
     * 2.遇到连续相同的元素，将后面的元素放到前面去。
     * 3.不考虑剩下位置的数组的元素
     *  @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = new No26LeetCode().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(n);
    }

}
