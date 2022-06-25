package week4.example;

/**
 * leetcode:704. 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        //int[] nums = {-1,0,3,5,9,12};
        int[] nums = {5};
        int target = 5;
        int ans = binarySearch.search(nums, target);
        System.out.println(ans);

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
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
