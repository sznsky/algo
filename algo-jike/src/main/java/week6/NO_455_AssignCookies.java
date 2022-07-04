package week6;

import java.util.Arrays;

/**
 * leetcode:455. 分发饼干
 */
public class NO_455_AssignCookies {

    public static void main(String[] args) {
        NO_455_AssignCookies assignCookies = new NO_455_AssignCookies();
        int[] g = {1,2,3};
        int[] s = {3};
        int ans = assignCookies.findContentChildren(g,s);
        System.out.println(ans);
    }

    /**
     * 思路：1.将孩子的胃口值和饼干尺寸大小依次排序
     * 2.遍历孩子的胃口值，在里面while循环饼干的尺寸，如果孩子的胃口值大于饼干尺寸，说明该尺寸的饼干满足不了任何孩子，饼干++
     * 3.如果饼干尺寸刚好满足了孩子胃口值，饼干也++,已经满足了一个孩子，不能满足第二个孩子
     * 4.防止出界
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for(int i=0;i<g.length;i++){
            while (j<s.length && s[j] < g[i]){
                j++;
            }
            if(j<s.length){
                j++;
                ans++;
            }
        }
        return ans;
    }

}
