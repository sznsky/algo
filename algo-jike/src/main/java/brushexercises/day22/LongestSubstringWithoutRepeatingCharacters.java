package brushexercises.day22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Describe :leetcode: 3. 无重复字符的最长子串
 * @Author : sunzhenning
 * @Since : 2022/6/20 19:38
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        /**
         * "abcabcbb"
         * "bbbbb"
         * "pwwkew"
         */
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        int ans = characters.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    /**
     * 滑动窗口思想：
     * 1.比如abcabcbb，虚拟一个窗口，从左向右移动。left=0,right++,一旦出现重复元素的时候，left++,right++
     * 2.记录i-left+1的最大值，就是最大的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<String,Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            String chr = String.valueOf(chars[i]);
            if(map.containsKey(chr)){
                left = Math.max(left, map.get(chr)+1);
            }
            map.put(chr,i);
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }

}
