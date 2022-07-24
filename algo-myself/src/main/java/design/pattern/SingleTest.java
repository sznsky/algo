package design.pattern;

/**
 * @Describe : 单例模式测试
 * @Author : sunzhenning
 * @Since : 2022/7/20 18:00
 */
public class SingleTest {
    public static void main(String[] args) {
        Single single = Single.getInstance();
        Single single1 = Single.getInstance();
        System.out.println(single == single1);
    }
}
