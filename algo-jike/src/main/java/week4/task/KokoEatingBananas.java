package week4.task;

/**
 * @Describe : leetcode:875. 爱吃香蕉的珂珂
 * @Author : sunzhenning
 * @Since : 2022/6/23 19:56
 * 思路：二分
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[] piles = {3,6,7,11};
        int h = 8;
        int ans = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(ans);
    }

    /**
     * 思路分析：珂珂爱吃香蕉，每个小时最大吃香蕉量为所有的香蕉之和，最小吃香蕉量
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > h) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }



}
