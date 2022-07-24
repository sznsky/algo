package design.pattern;

/**
 * @Describe : 懒汉式：双重检查
 * @Author : sunzhenning
 * @Since : 2022/7/20 18:18
 */
public class Single1 {
    //将对象静态私有化，只能存在一个
    private static Single1 single1;
    //私有化构造方法，只能通过new的方式创建
    private Single1(){}

    //对外的公共静态方法
    public static Single1 getInstance(){
        if(single1 == null){
            synchronized(Single1.class){
                if(single1 == null){
                    return new Single1();
                }
            }
        }
        return single1;
    }

}
