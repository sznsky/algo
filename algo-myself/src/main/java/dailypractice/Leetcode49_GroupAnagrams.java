package dailypractice;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class Leetcode49_GroupAnagrams {

    public static void main(String[] args) {
        Leetcode49_GroupAnagrams leetcode49_groupAnagrams = new Leetcode49_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //String[] strs = {"a"};
        List<List<String>> result = leetcode49_groupAnagrams.groupAnagramsNew(strs);
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 新的思路解法：
     * 1.for循环遍历原数组，将元素按照a-z顺序排序，排序以后添加到map中，值为下标
     * 2.如果Map中存在，则继续添加下标，如果不存在，则put新的元素作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsNew(String[] strs) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            str = new String(chars);
            List<Integer> list;
            if(map.containsKey(str)){
                list = map.get(str);
            }else{
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(str,list);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
            List<Integer> indexList = entry.getValue();
            System.out.println(Arrays.toString(indexList.toArray()));
            List<String> item = new ArrayList<>();
            for(int i=0;i < indexList.size();i++){
                item.add(strs[indexList.get(i)]);
            }
            result.add(item);
        }
        return result;
    }

    /**
     * 朴素解法：
     * 1.定义一个和原数组相同长度的数组，然后将新数组的字母排序，但是index和原数组一致
     * 2.对这个新数组，双重for循环，两两比较，将相同的字母对应的原数组放到同一个小数组中
     * 3.注意边界，将已经放到小数组中的下标的值置为null,下次比较的时候，过滤掉null值。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] strsNew = new String[strs.length];
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strHandle = new String(chars);
            strsNew[i] = strHandle;
        }
        List<List<String>> result = new ArrayList<>();
        for(int i =0;i<strsNew.length;i++){
            if(strsNew[i] == null){
                continue;
            }
            List<String> item = new ArrayList<>();
            item.add(strs[i]);
            if(i < strsNew.length-1){
                for(int j=i+1;j<strsNew.length;j++){
                    if(strsNew[i] != null && strsNew[j]!= null && strsNew[i].equals(strsNew[j])){
                        strsNew[j] = null;
                        item.add(strs[j]);
                    }
                }
            }
            strsNew[i] = null;
            result.add(item);
        }
        return result;
    }
}
