package brushexercises.day44;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/12 16:37
 */
public class NO_152_MaximumProductSubarray1 {

    public static void main(String[] args) {
        NO_152_MaximumProductSubarray maximumProductSubarray = new NO_152_MaximumProductSubarray();
        int[] nums = {2,3,2,4};
        int ans = maximumProductSubarray.maxProduct(nums);
        System.out.println(ans);
    }

    /**
     * 维护一个前置最大值和最小值，遇到负数，最大变最小，最小的变最大的。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return max;
    }
}
