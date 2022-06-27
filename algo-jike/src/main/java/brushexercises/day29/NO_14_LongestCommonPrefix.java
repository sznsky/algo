package brushexercises.day29;

/**
 * @Describe :14. 最长公共前缀
 * @Author : sunzhenning
 * @Since : 2022/6/27 16:48
 */
public class NO_14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        NO_14_LongestCommonPrefix longestCommonPrefix = new NO_14_LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
    /**
     * 思路：朴素解法
     * 1.将一个字符串赋给结果ans
     * 2.外层for遍历字符串数组。内层遍历ans和当前字符串对应字符，只要发现一个不匹配，返回j
     * 3.外层从1开始遍历
     * 4.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || "".equals(strs)){
            return "";
        }
        String ans = strs[0];
        for(int i=1;i<strs.length;i++){
            int j = 0;
            for(;j<ans.length() && j<strs[i].length();j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }




}
