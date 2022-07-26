package week9.example;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * nums = [1,1,2,1,1], k = 3
 * 输出 2
 * 包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 */
public class NO_1248_CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        NO_1248_CountNumberOfNiceSubarrays countNumberOfNiceSubarrays = new NO_1248_CountNumberOfNiceSubarrays();
        int[] nums = {1,1,2,1,1};
        int k = 3;
        int ans = countNumberOfNiceSubarrays.numberOfSubarrays(nums, k);
        System.out.println(ans);
    }

    /**
     * 思路：
     * 1.原问题：子段的奇数数量
     * 新问题：奇数看作是1，偶数看作是0（每个数mod 2）,统计字段和是k的子段的数量
     * 2.sum(l,r) == k,也可以这样写：S[r] - S[l-1] == k
     * 两数之差：一个数是S[r],一个数是S[l-1]
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        //s表示前缀和：s范围 [0-n],包含n的
        int[] s = new int[n+1];
        s[0] = 0;
        for(int i=1;i<=n;i++){
            //前缀和：奇数看作1，偶数看作0,这个前缀和就是奇数的个数
            s[i] = s[i-1] + nums[i-1]%2;
        }
        //计数数组
        int[] count = new int[n+1];
        int ans = 0;
        count[s[0]] =1;
        for(int i=1;i<=n;i++){
            if(s[i] - k >= 0){
                ans = ans + count[s[i] -k];
            }
            count[s[i]] ++;
        }
        return ans;
    }
}
