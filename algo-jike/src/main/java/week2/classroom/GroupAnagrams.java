package week2.classroom;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Describe : 49. 字母异位词分组
 * @Author : sunzhenning
 * @Since : 2022/6/7 11:39
 * 思路：使用map存储
 * {
 *     "aet": ["eat", "tea", "ate"],
 *     "ant": ["tan", "nat"],
 *     "abt": ["bat"]
 * }
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> groupMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(groupMap.containsKey(sortStr)){
                groupMap.get(sortStr).add(str);
            }else{
                List<String> strList = new ArrayList();
                strList.add(str);
                groupMap.put(sortStr,strList);
            }
        }
        //遍历groupMap
        for(Map.Entry<String,List<String>> map : groupMap.entrySet()){
            List<String> value = map.getValue();
            result.add(value);
        }
        return result;
    }


}
