package brushexercises.day26;

/**
 * @Describe : leetcode:26. 删除有序数组中的重复项
 * @Author : sunzhenning
 * @Since : 2022/6/24 23:41
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();


    }

    /**
     * 思路：1.开辟一个新的指针
     * 2.后一个和前一个比较，不相同，就将后一个赋值给nums[n],n++
     * 3.注意边界
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }
}
