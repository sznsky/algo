package brushexercises.day26;

/**
 * @Describe : leetcode：11. 盛最多水的容器 【经典问题：第三次做】
 * @Author : sunzhenning
 * @Since : 2022/6/24 20:54
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = container.maxArea(height);
        System.out.println(ans);
    }

    /**
     * 思路分析：双指针，left,right
     * 1.如果height[left] < height[right],left++，j不动；
     * 2.如果height[left] > height[right],right++，i不动；
     * 3.双指针走动的过程中，更新最大值作为答案
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            ans = Math.max(ans, x*y);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return ans;
    }
}
