package week4.example;

/**
 * @Describe : leetcode:704. 二分查找
 * @Author : sunzhenning
 * @Since : 2022/6/23 11:28
 * nums = [-1,0,3,5,9,12], target = 9
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int ans = binarySearch.search(nums, target);
        System.out.println(ans);
    }

    /**
     * 简单的二分查找
     * 二分查找的前提：1.数组且有序,2.数组不重复
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            //中间下标值是根据left和right变化的
            int mid = (left+right)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
