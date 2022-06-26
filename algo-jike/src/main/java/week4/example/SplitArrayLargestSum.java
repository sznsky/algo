package week4.example;

/**
 * leetcode:410. 分割数组的最大值
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        int ans = splitArrayLargestSum.splitArray(nums,m);
        System.out.println(ans);
    }
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }
        while (left < right){
            int mid = (left + right) / 2;
            if(validate(nums,m,mid)){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return right;
    }

    /**
     * 验证
     * @param nums 数组
     * @param m m个分割数字(最多多少个盒子)
     * @param size 盒子最大容量
     * @return
     */
    private boolean validate(int[] nums,int m,int size){
        //盒子中装数字的多少，临时变量
        int box = 0;
        //需要多少个盒子
        int count = 1;
        for(int num : nums){
            //size容量装的下box+num数字
            if(box + num <= size){
                box = box + num;
            }else{
                //装不下，新增加盒子，同时将
                count++;
                //盒子容量太小，一个数字值都装不下，直接返回false
                if(num > size){
                    return false;
                }
                box = num;
            }
        }
        return count <= m;
    }
}
