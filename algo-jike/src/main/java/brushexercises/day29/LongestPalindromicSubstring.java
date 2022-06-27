package brushexercises.day29;

/**
 * @Describe : leetcode:5. 最长回文子串
 * @Author : sunzhenning
 * @Since : 2022/6/27 10:59
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String s = "aba";
        String ans = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(ans);
    }

    /**
     * 思路：1.双层for循环,找出所有的字符串，校验是否是回文，如果是，和答案比较长度，留下长度长的
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1){
            return s;
        }
        //整个字符串就是回文，直接返回
        if(validate(s)){
            return s;
        }
        String ans = "";
        //遍历所有的子字符串，判断回文，取出最长的
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String childStr = s.substring(i,j+1);
                if(validate(childStr)){
                    if(childStr.length() > ans.length()){
                        ans = childStr;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 判断一个字符串是否是回文字符串
     * @param s
     * @return
     */
    private boolean validate(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
