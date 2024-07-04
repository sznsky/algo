package test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ZhaoshangTest1 {

    public static void main(String[] args) {
//        String input = "这是一个例子，包含中文标点符号！。？（）【】";
//        String output = input.replaceAll("[\\p{P}&&[^\\p{Punct}]]", "");
//        System.out.println(output);  // 输出 "这是一个例子包含中文标点符号"
//
//        String input1 = "Hello, World! This is a test.(),[]";
//        String output1 = input1.replaceAll("[^\\p{L}\\p{N}]", "");
//        System.out.println(output1);  // 输出 "HelloWorldThisisatest"
//
//        String input2 = "这是一个例子，包含中文标点符号！。？（）【】， Hello, World! This is a test.(),[]，？?";
//        //String output2 = input2.replaceAll("[\\p{P}&&[^\\p{Punct}]]", "");
//        String output2 = input2.replaceAll("[^\\p{L}\\p{N}]", "");
//        System.out.println(output2);
//
//        System.out.println(isAllDigitsAndLetters("1234567890"));
//        System.out.println(isAllDigitsAndLetters("1234567890Wxzxx"));
//        System.out.println(isAllDigitsAndLetters("Wxzxx"));
//        System.out.println(isAllDigitsAndLetters("1234567890W"));
//
//        String str = "郭红军\t432522197810266310\t15080821287\thttps://s.yyjzt.com/pri/jzt-dzsy/20230210/1676004117205ac0.jpg\thttps://s.yyjzt.com/pri/jzt-dzsy/20230210/1676004135189593.jpg\t816776\t325971\t2199-12-31 00:00:00\t1\n" +
//                "李清涛\t370783198409113991\t13964785222\thttps://s.yyjzt.com/pri/jzt-dzsy/20240307/1709771328846261b.png\thttps://s.yyjzt.com/pri/jzt-dzsy/20240307/17097713323655b01.png\t816799\t325981\t2199-12-31 00:00:00\t1\n" +
//                "范凌云\t210804198004213527\t15541753283\thttps://s.yyjzt.com/pri/jzt-dzsy/20240306/1709730792325a5e.jpg\thttps://s.yyjzt.com/pri/jzt-dzsy/20240306/17097307977687fe.jpg\t816806\t325984\t2199-12-31 00:00:00\t1\n" +
//                "袁宏伟\t220302196812020056\t15304348777\thttps://s.yyjzt.com/pri/jzt-dzsy/20240307/170977215471150f0.jpg\thttps://s.yyjzt.com/pri/jzt-dzsy/20240307/1709772160933fc64.jpg\t816826\t325991\t2199-12-31 00:00:00\t1\n";
//        String[] arr = str.split("\t");
//
//        Long x = 1L;
//        System.out.println(x==1);
//        System.out.println(Arrays.toString(arr));

        double a = 0.1;
        double b = 0.2;
        double c = 0.3;
        System.out.println(a+b);
        BigDecimal aDecimal = new BigDecimal(String.valueOf(a));
        BigDecimal bDecimal = new BigDecimal(String.valueOf(b));
        System.out.println(aDecimal.add(bDecimal));
    }

    private String removeCharacterOfCNEN(String str){
        String input = "这是一个例子，包含中文标点符号！。？（）【】， Hello, World! This is a test.(),[]，？?";
        String output = input.replaceAll("[\\p{P}&&[^\\p{Punct}]]", "");
        output = input.replaceAll("[^\\p{L}\\p{N}]", "");
        System.out.println(output);
        return output;
    }

    // 判断字符串是否全部由数字和字母组成
    public static boolean isAllDigitsAndLetters(String str) {

        return str.matches("[a-zA-Z\\d]+");
    }

}
