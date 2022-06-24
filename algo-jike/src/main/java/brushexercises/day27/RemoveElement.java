package brushexercises.day27;

/**
 * @Describe : leetcode:27. 移除元素
 * 备注：本题和【 leetcode:26. 删除有序数组中的重复项】相似
 * @Author : sunzhenning
 * @Since : 2022/6/25 1:53
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {03,2,2,3};
        int val = 2;
        int ans = removeElement.removeElement(nums, val);
        System.out.println(ans);
    }

    /**
     * 思路：1.开辟一个新的指针n
     * 2.遍历nums,元素的值不等于val时候，将nums[n]=nums[i]
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }


}
