package brushexercises.day30;

/**
 * @Describe : leetcode:704. 二分查找
 * @Author : sunzhenning
 * @Since : 2022/6/28 14:33
 */
public class NO_704_BinarySearch {

    public static void main(String[] args) {
        NO_704_BinarySearch binarySearch = new NO_704_BinarySearch();
        int[] nums = {5};
        int target = 5;
        int ans = binarySearch.search(nums,target);
        System.out.println(ans);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
