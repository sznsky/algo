package brushexercises.day42;

/**
 * @Describe :
 * @Author : sunzhenning
 * @Since : 2022/7/12 9:27
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class NO_11_ContainerWithMostWater {

    public static void main(String[] args) {
        NO_11_ContainerWithMostWater container = new NO_11_ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans = container.maxArea(height);
        System.out.println(ans);
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int ans = 0;
        for(int i=0;i<height.length;i++){
            int left = height[i];
            int right = height.length-1;
             while (left < right){
                 //求最大面积
                 ans = Math.max(Math.min(height[left],height[right])*(right-left),ans);
                 if(height[left] < height[right]){
                     left++;
                 }else{
                    right--;
                 }
             }
        }
        return ans;
    }

}
