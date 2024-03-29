package brushexercises.day44;

/**
 * @Describe :152. 乘积最大子数组
 * @Author : sunzhenning
 * @Since : 2022/7/12 15:26
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个32-位 整数。
 * 子数组 是数组的连续子序列。\
 * 输入: nums = [2,3,4,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class NO_152_MaximumProductSubarray {

    public static void main(String[] args) {
        NO_152_MaximumProductSubarray maximumProductSubarray = new NO_152_MaximumProductSubarray();
        int[] nums = {2,3,2,4};
        int ans = maximumProductSubarray.maxProduct(nums);
        System.out.println(ans);
    }

    public int maxProduct(int[] nums) {
        //给出边界最小值作为最大值，小技巧，最后被替换了
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0;i<nums.length;i++){
            //出现负数的情况下，最大变最小，最小的变最大
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //维护一个最大的乘积和最小的乘积
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
