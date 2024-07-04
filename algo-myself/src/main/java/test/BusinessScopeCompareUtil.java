package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 经营简码范围工具类
 */
public class BusinessScopeCompareUtil {

    /**
     * 返回超出范围的经营简码：新的经营简码和原经营简码比较
     * 找出在新的经营简码中没有包含的原经营简码，并返回
     *
     * @return
     */
    public static Set<String> outOfRange(Set<String> originalBusinessScopes, Set<String> nowBusinessScopes){
        Set<String> result = new HashSet<>();
//        //原经营简码为空，直接返回空
//        if(Collections.is(originalBusinessScopes)){
//            return result;
//        }
//        //如果现在的经营为空，那么原经营简码都超出范围
//        if(CollectionUtil.isEmpty(nowBusinessScopes)){
//            return originalBusinessScopes;
//        }
        //找出原经营简码不在现经营简码的
        for(String originalBusinessScope : originalBusinessScopes){
            //存在于现在的经营简码中
            if(nowBusinessScopes.contains(originalBusinessScope)){
                continue;
            }
            //是否包含于现在的经营简码中
            boolean containFlag = false;
            for(String nowBusinessScope : nowBusinessScopes){
                //比如原经营简码0510 现经营简码05
                if(originalBusinessScope.startsWith(nowBusinessScope)){
                    containFlag = true;
                    break;
                }
            }
            //超出范围的经营简码
            if(!containFlag){
                result.add(originalBusinessScope);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> originalBusinessScopes = new HashSet<>();
        originalBusinessScopes.add("0101");
        originalBusinessScopes.add("0201");
        originalBusinessScopes.add("03");
        originalBusinessScopes.add("0401");
        originalBusinessScopes.add("051010");

        Set<String> nowBusinessScopes = new HashSet<>();
        nowBusinessScopes.add("01");
        nowBusinessScopes.add("0201");
        nowBusinessScopes.add("0301");
        nowBusinessScopes.add("051010");


        Set<String> outOfRange = outOfRange(originalBusinessScopes, nowBusinessScopes);
        System.out.println(Arrays.toString(outOfRange.toArray()));

    }


}
