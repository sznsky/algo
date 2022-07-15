package brushexercises.day47;

/**
 * @Describe : 打家劫舍
 * @Author : sunzhenning
 * @Since : 2022/7/15 17:20
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *  偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class NO_198_HouseRobber {

    public static void main(String[] args) {
        NO_198_HouseRobber houseRobber = new NO_198_HouseRobber();
        int[] nums = {1,2,3,1};
        int ans = houseRobber.rob(nums);
        System.out.println(ans);
    }

    /**
     * 子问题：f(k) = 偷(0...k)个房间中的最大金额
     * 两种方案：1.偷前k-1个房间，最后一个房间不偷，假如偷的方法为f(x) 2.偷前k-2个放假+最后一间,假如偷的方法为f(k-2)+last
     * 这两种方案取大
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int N = nums.length;
        //房子的序号从1到N
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int k=2;k<= N;k++){
            //二种情况：要么从前k-1个房间中偷，要么从前k-2个房间偷+最后一个房间
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[k-1]);
        }
        return dp[N];
    }
}
