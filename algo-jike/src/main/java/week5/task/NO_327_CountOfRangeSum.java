package week5.task;

import java.util.*;

/**
 * leetcode:327,区间和个数
 */
public class NO_327_CountOfRangeSum {

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;
        NO_327_CountOfRangeSum countOfRangeSum = new NO_327_CountOfRangeSum();
        int ans = countOfRangeSum.countRangeSum(nums,lower,upper);
        System.out.println(ans);
    }

    /**
     * 前缀和思想
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> set = new HashSet<>();
        long s = 0;
        set.add(s);
        for (int i : nums) {
            s += i;
            set.add(s);
            set.add(s - lower);
            set.add(s - upper);
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Long, Integer> map = new HashMap<>();
        for (long x : list) map.put(x, ++m);
        s = 0;
        int ans = 0;
        add(map.get(s), 1);
        for (int i : nums) {
            s += i;
            int a = map.get(s - lower), b = map.get(s - upper) - 1;
            ans += query(a) - query(b);
            add(map.get(s), 1);
        }
        return ans;
    }

    int m;
    //前缀和数组
    int[] tr = new int[100010 * 3];
    int lowbit(int x) {
        return x & -x;
    }
    //前缀和方法
    void add(int x, int v) {
        for (int i = x; i <= m; i += lowbit(i)) tr[i] += v;
    }
    //根据x查询前缀和
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }





}
