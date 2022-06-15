package brushexercises.day17;

/**
 * @Describe :leetcode :11. 盛最多水的容器
 * @Author : sunzhenning
 * @Since : 2022/6/15 17:28
 * 再次做这个题，很经典的题目
 * 思路：双指针，左右指针。
 * （1）当height[left] < height[right] ，left++,right不动。
 * 因为容器盛水的多少取决于短板，也就是left的高度。此时若right++，宽度就减少1，而left不变，肯定不是最大的盛水容量，容量只能减少。
 * 若left++,宽度减少1，新的height[left]，可能变大，也肯变小。至少还存在可能变大的可能。
 * （2）当height[left] > = height[right] ，left不动,right--。一样的道理
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] height = {1,1};
        container.maxArea(height);
        System.out.println(container.ans);
    }

    private int ans;
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        while (left < right){
            int s = (right-left)*(Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            ans = Math.max(ans,s);
        }
        return ans;
    }

}
