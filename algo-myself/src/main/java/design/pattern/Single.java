package design.pattern;

/**
 * @Describe : 双重检查的单例
 * @Author : sunzhenning
 * @Since : 2022/7/20 17:56
 */
public class Single {
    //静态私有化属性，使其不能通过其他的类来修改
    private static Single single;
    //私有化构造方法，使其不能new的方式创建
    private Single(){}
    //对外公共方法
    public static Single getInstance(){
        //双重检查
        if(single == null){
            synchronized (Single.class){
                if(single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }


}
