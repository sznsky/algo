package week5.example;

import java.util.Arrays;

/**
 * leetcode:1122. 数组的相对排序
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class NO_1122_RelativeSortArray {

    public static void main(String[] args) {
        NO_1122_RelativeSortArray relativeSortArray = new NO_1122_RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ans = relativeSortArray.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 计数排序：很巧妙，需要确定范围
     * 时间复杂度O(N+M),N为元素的个数，M数值的范围
     * 1.创建答案的数组,arr1的长度
     * 2.创建计数数组的长度,1001的长度
     * 3.将arr1计数排序
     * 4.按照arr2的顺序来读取
     * 5.剩余的没有在arr2出现的过，按照顺序取出
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //因为对arr1数组按照arr2的顺序排序，所以答案的长度就是arr1的长度
        int[] ans = new int[arr1.length];
        //给答案计数的n
        int n = 0;
        //创建计数数组的长度，大于最大的数
        int[] count = new int[1001];
        //扫描arr1,将arr1中元素对应的count计数，也就是对arr1元素的个数计数
        for(int i=0;i<arr1.length;i++){
            count[arr1[i]] = count[arr1[i]]+1;
        }
        //arr2元素，存在arr1中的，按照arr2的顺序读取arr1的中数
        for(int i=0;i<arr2.length;i++){
            while(count[arr2[i]] > 0){
                count[arr2[i]] --;
                ans[n] = arr2[i];
                n++;
            }
        }
        //没有存在arr2中的arr1中的元素，按照arr1中的顺序获取
        for(int val=0;val<=1000;val++){
            while (count[val] > 0){
                count[val]--;
                ans[n] = val;
                n++;
            }
        }
        return ans;
    }

}
