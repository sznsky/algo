package brushexercises.day27;

/**
 * @Describe : leetcode:9. 回文数
 * @Author : sunzhenning
 * @Since : 2022/6/25 2:21
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = -120;
        boolean ans = palindromeNumber.isPalindrome(x);
        System.out.println(ans);
    }

    /**
     * 转字符串处理
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0){
            return false;
        }
        String xStr = String.valueOf(x);
        char[] chars = xStr.toCharArray();
        for(int i=0;i<chars.length/2;i++){
            if(chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
