package week7.task;

/**
 * 55. 跳跃游戏
 */
public class NO_55_JumpGame {

    /**
     * 思路：1.从后往前遍历数组，如果元素可以到达最后一行，则截断，继续遍历下一个，否则继续遍历
     * 2.如果最后剩下的元素大于1个，那么，所有的步骤不可能走完，返回false
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = 1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] >= n){
                n=1;
            }else{
                n++;
            }
            if(i == 0 && n>1){
                return false;
            }
        }
        return true;
    }
}
