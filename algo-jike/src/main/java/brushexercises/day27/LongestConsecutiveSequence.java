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
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        //int[] nums = {0,3,7,2,5,8,4,6,1};
        //int[] nums = {100,4,200,1,3,2};
        //int[] nums = {1,2,0,1};
        int ans = sequence.longestConsecutive(nums);
        System.out.println(ans);
    }

    /**
     * 思路：题目要求O(n)的时间复杂度完成，双层for循环的遍历，肯定不行了
     * 1。时间换空间，使用set先把nums存入
     * 2.然后基于nums其中任何一个元素左右遍历
     * 3.更新结果答案
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        //先把所有的几个加入set中
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int num : nums){
            if(set.remove(num)){
                //记录当前循环中。最长的连续数的长度
                int currentLongest = 1;
                int leftCurrentNum = num;
                //向左遍历,遇到连续的，leftCurrentNum--
                while(set.remove(leftCurrentNum -1)) {
                    leftCurrentNum--;
                }
                currentLongest = currentLongest + (num - leftCurrentNum);
                //向右遍历，遇到连续的，rightCurrentNum++
                int rightCurrentNum = num;
                while(set.remove(rightCurrentNum +1)){
                    rightCurrentNum ++;
                }
                currentLongest = currentLongest + (rightCurrentNum - num);
                //更新结果
                ans = Math.max(ans, currentLongest);
            }
        }
        return ans;
    }
}
