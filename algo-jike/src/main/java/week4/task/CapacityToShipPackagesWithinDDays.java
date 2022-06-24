package week4.task;

/**
 * leetcode:1011. 在 D 天内送达包裹的能力
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/6/23 16:22
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays capacity = new CapacityToShipPackagesWithinDDays();
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int ans = capacity.shipWithinDays(weights,days);
        System.out.println(ans);
    }

    /**
     * 分析：1.最大的运输能力为1天运完。那么最大的运输能力就是所有包裹质量的和
     * 2.由于包裹不能拆分，那么最低的运输能力就是最大包裹质量。
     * 3.该题的求解的是target的后继，在给定时间内运输完成的最小运力。
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        //1.确定left和right的初始值。left初始值表示最小运力,right初始值表示最大运力
        int left = 0, right = 0;
        for(int i=0;i<weights.length;i++){
            int weight = weights[i];
            Math.max(left, weight);
            right = right + weight;
        }
        //2.开始模拟运输
        while(left < right){
            //折中的运力
            int mid = (left+right) / 2;
            //需要运输的天数
            int count = 1;
            //每天的运输总和
            int sum = 0;
            for(int i=0;i<weights.length;i++){
                if(sum + weights[i] > mid){
                    count++;
                    sum = 0;
                }
                sum = sum + weights[i];
            }
            if(count > days){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}