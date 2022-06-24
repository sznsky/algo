package brushexercises.day27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Describe :leetcode: 128. 最长连续序列
 * @Author : sunzhenning
 * @Since : 2022/6/25 4:45
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        //int[] nums = {0,3,7,2,5,8,4,6,0,1};
        //int[] nums = {0,3,7,2,5,8,4,6,1};
        //int[] nums = {100,4,200,1,3,2};
        int[] nums = {1,2,0,1};
        int ans = sequence.longestConsecutive(nums);
        System.out.println(ans);
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = 1;
        int n = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        set.stream().sorted();
        for(int i=1;i<nums.length;i++){
            if(nums[i] - nums[i-1] == 1){
                n++;
                ans = Math.max(ans,n);
            }else{
                n = 1;
            }
        }
        return ans;
    }
}
