package brushexercises.day27;

/**
 * @Describe : leetcode:9. 回文数
 * @Author : sunzhenning
 * @Since : 2022/6/25 2:21
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 123321;
        boolean ans = palindromeNumber.isPalindrome1(x);
        System.out.println(ans);
    }

    /**
     * 优化方案：数学解法
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0){
            return false;
        }
        if(x%10==0 && x!=0){
            return false;
        }
        int reverseNumber = 0;
        while(x > reverseNumber){
            reverseNumber = reverseNumber*10 +x%10;
            x = x/10;
        }
        //注意：当x长度为奇数用这个x== reverseNumber/10比较
        //：当x长度为偶数用这个x== reverseNumber比较
        return x == reverseNumber || x== reverseNumber/10;
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
