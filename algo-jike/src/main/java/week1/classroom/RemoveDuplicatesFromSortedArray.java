package week1.classroom;

/**
 * leetcode:26
 * 删除有序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray fromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,2};
        int n = fromSortedArray.removeDuplicates(nums);
        System.out.println(n);
    }




    /**
     * 思路：
     * 1.遍历数组
     * 2.后一个元素和前一个元素比较,不相同的留下，相同就不管
     * 3.确定边界
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //定义一个指针
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i] != nums[i-1]){
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }


}
