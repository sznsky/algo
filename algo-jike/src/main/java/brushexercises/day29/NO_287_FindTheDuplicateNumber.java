package brushexercises.day29;

/**
 * @Describe : leetcode:287. 寻找重复数
 * @Author : sunzhenning
 * @Since : 2022/6/27 18:19
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class NO_287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        NO_287_FindTheDuplicateNumber findTheDuplicateNumber = new NO_287_FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        int ans = findTheDuplicateNumber.findDuplicate(nums);
        System.out.println(ans);
    }

    /**
     * 思路：将这个问题转为leetcode:142问题，建立一个类似链表的关系
     * 1.如果没有重复数字的数组[1,3,4,2],n->f(n)建立简单的映射关系，得出：
     * n=0 f(0)=1,n=1 f(1)=3,f(2)=4,f(3)=2,用已计算出的f(n)的值作为下标可以得出：
     * n=0,f(0)=1
     * n=1,f(1)=3
     * n=3,f(3)=2,
     * n=2,f(2)=4,
     * n=4,f(4)=null
     * 结论：没有重复数字情况，没有环
     * 2.如果有重复数字的数组[1,3,4,2,2],n->f(n)建立简单的映射关系，得出：
     * n=0 f(0)=1,n=1 f(1)=3,f(2)=4,f(3)=2,f(4)=2,用已计算出的f(n)的值作为下标可以得出：
     * n=0,f(0)=1
     * n=1,f(1)=3
     * n=3,f(3)=2
     * n=2,f(2)=4
     * n=4,f(4)=2
     * n=2,f(2)=4
     * 。。。。。类似链表的环产生了
     * 借鉴leetcode:142问题：
     * 使用快指针：slow=>slow.next  转为slow=nums[slow]
     * 使用快指针，fast=fast.next.next 转为fast=nums[nums[fast]]
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
