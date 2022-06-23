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

    public int shipWithinDays(int[] weights, int days) {
        // 划分数组类问题。
        // 怎么使用二分呢，我们可以这样想，
        // 如果想要让所有货物在一天内被运载，那么船的最低承重应该是所有货物的和
        // 如果想要让所有货物最慢被运载，那么船的承重就应该是货物的最大值
        // 这个就是左右边界
        int left = 0, right = 0;
        for (int x : weights) {
            left = Math.max(left, x);
            right += x;
        }
        while (left < right) {
            int mid = (left + right)/2;
            int cnt = 1; // 需要的天数记录
            int sum = 0;
            for (int w : weights) {
                if (sum + w > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += w;
            }
            if(cnt > days){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}