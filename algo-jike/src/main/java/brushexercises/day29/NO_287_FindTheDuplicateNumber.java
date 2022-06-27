package brushexercises.day29;

/**
 * @Describe : leetcode:287. 寻找重复数
 * @Author : sunzhenning
 * @Since : 2022/6/27 18:19
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class NO_287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        NO_287_FindTheDuplicateNumber findTheDuplicateNumber = new NO_287_FindTheDuplicateNumber();
        int[] nums = {3,1,3,4,2};
        int ans = findTheDuplicateNumber.findDuplicate(nums);
        System.out.println(ans);
    }

    public int findDuplicate(int[] nums) {
        int n = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                return nums[i-1];
            }
        }
        return 0;
    }
}
