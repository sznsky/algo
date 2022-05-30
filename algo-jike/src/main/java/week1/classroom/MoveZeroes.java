package week1.classroom;

/**
 * leetcode:283
 * 数组保序，同时将所有的0移动到数组末尾
 */
public class MoveZeroes {


    /**
     * 思路：
     * 1.将不为零的元素留下了，剩下的根据数组的长度补零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[n] = nums[i];
                n++;
            }
        }
        while(n < nums.length){
            nums[n] = 0;
            n++;
        }
    }



}
