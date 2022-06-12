package brushexercises.day14;

/**
 * leetcode:11 盛最多水的容器
 */
public class ContainerMostWater {

    public static void main(String[] args) {
        ContainerMostWater containerMostWater = new ContainerMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = containerMostWater.maxArea(height);
        System.out.println(ans);
    }

    /**
     * 思路:左右指针
     * 1.如果left<right left++,right不动
     * 2.如果left>right right--,left不动
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            //高度：储水量取决短板
            int y = Math.min(height[left],height[right]);
            //宽度：
            int x = right - left;
            ans = Math.max(ans,x*y);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return ans;
    }
}
