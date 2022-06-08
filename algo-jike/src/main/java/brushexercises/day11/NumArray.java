package brushexercises.day11;

/**
 * @Describe : leetcode:303 区域和检索 - 数组不可变
 * @Author : sunzhenning
 * @Since : 2022/6/8 17:37
 * 思路：朴素解法，就是通过数组下标找到元素，然后累加求和
 * 初始化的时间复杂度O(n),求和的时间复杂度还是O(n),最终的时间复杂度还是O(n)
 */
public class NumArray {

    private int[] array;

    public NumArray(int[] nums) {
        array = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            array[i] = nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        int i = left;
        while(i<= right){
            ans += array[i];
            i++;
        }
        return ans;
    }
}
