package brushexercises.day59;

/**
 * 28. 实现 strStr()
 */
public class NO_28_ImplementStrstr {

    public static void main(String[] args) {
        NO_28_ImplementStrstr implementStrstr = new NO_28_ImplementStrstr();
        String haystack = "hello";
        String needle = "ll";
        int ans = implementStrstr.strStr(haystack, needle);
        System.out.println(ans);
    }

    /**
     * 朴素解法：直接枚举所有原字符串
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        //注意:只需要n-m次外循环即可
        for(int i=0;i<=n-m;i++){
            int a = i;//haystack的指针，每次从i开发发起的
            int b = 0;//needle的指针，每次从0开始发起
            while (b < m && haystack.charAt(a) == needle.charAt(b)){
                a++;
                b++;
            }
            if(b == m){
                return i;
            }
        }
        return -1;
    }
}
