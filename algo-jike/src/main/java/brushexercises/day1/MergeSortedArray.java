package brushexercises.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe :给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author : sunzhenning
 * @Since : 2022/5/30 12:47
 */
public class MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;

        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {0};
        int n = 0;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 合并数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] result = new int[m+n];
        //给nums1，nums2定义两个指针i,j
        int i = 0,j = 0,k = 0;
        while(i<m || j<n){
            if(j>=n || (i<m && (nums1[i] <= nums2[j]))){
                result[k] = nums1[i];
                i++;
            }else{
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        for(int x=0;x<result.length;x++){
            nums1[x] = result[x];
        }
    }
}
