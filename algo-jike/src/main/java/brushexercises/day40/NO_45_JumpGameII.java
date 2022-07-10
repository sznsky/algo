package brushexercises.day40;

/**
 * 45. 跳跃游戏 II
 */
public class NO_45_JumpGameII {

    public static void main(String[] args) {
        NO_45_JumpGameII jumpGameII = new NO_45_JumpGameII();
        int[] nums = {2,3,1,1,4};
        int ans = jumpGameII.jump(nums);
        System.out.println(ans);
    }

    public int jump(int[] nums) {
        int ans = 0;
        int begin = 0;
        int end = 0;
        while (end < nums.length-1){
            int temp = 0;
            for(int i = begin;i<=end;i++){
                temp = Math.max(nums[i]+i,temp);
            }
            begin = end+1;
            end = temp;
            ans++;
        }
        return ans;
    }
}
