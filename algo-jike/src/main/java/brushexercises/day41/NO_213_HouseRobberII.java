package brushexercises.day41;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 */
public class NO_213_HouseRobberII {

    public static void main(String[] args) {
        NO_213_HouseRobberII houseRobberII = new NO_213_HouseRobberII();
        int[] nums = {2,3,2};
        int ans = houseRobberII.myRob(nums);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
