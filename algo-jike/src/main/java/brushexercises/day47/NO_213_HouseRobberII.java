package brushexercises.day47;

/**
 * @Describe : 213. 打家劫舍 II:有环了
 * @Author : sunzhenning
 * @Since : 2022/7/16 9:41
 */
public class NO_213_HouseRobberII {

    public static void main(String[] args) {
        NO_213_HouseRobberII houseRobberII = new NO_213_HouseRobberII();
        int[] nums = {1,2};
        int ans = houseRobberII.rob(nums);
        System.out.println(ans);
    }

    /**
     * 思路：
     * 在打家劫舍I的基础上：偷第一间，不偷最后一间；不偷第一间，偷最后一间
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int N = nums.length;
        if(N == 1){
            return nums[0];
        }

        //1.从第一间房开始偷，但是不偷最后一间，区间[1,n-1]
        int[] dp1 = new int[N+1];
        dp1[1] = nums[0];
        //按照打家劫舍1的方法计算：
        for(int k=2;k<=N-1;k++){
            dp1[k] = Math.max(dp1[k-1],dp1[k-2]+nums[k-1]);
        }

        //2.从第二间房开始开始偷，偷最后一间,区间[2,n]
        int[] dp2 = new int[N+1];
        dp2[2] = nums[1];
        //按照打家劫舍1的方法计算：
        for(int k=3;k<=N;k++){
            dp2[k] = Math.max(dp2[k-1],dp2[k-2]+nums[k-1]);
        }
        return Math.max(dp1[N-1],dp2[N]);
    }
}
