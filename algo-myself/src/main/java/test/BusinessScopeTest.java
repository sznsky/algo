package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 经营简码测试
 */
public class BusinessScopeTest {


    public static void main(String[] args) {
//        String[] nowBusinessScopeArr = {"0130","0127","0105","0128","0106","0125","0103","0126",
//                "0101","011601","0102","0121","0122","011605","011905","0129","011606","0107",
//                "011904","0120","0117","0114","0115",
//                "0112","010402","0110","010401","0111","010802","010901","010801","0118"};



        String str = " 0204, 0215, 0216, 0202, 0213, 020506, 0203, 0214, 02050101, 020505, 0211, " +
                "020504, 0201, 0212, 020503, 020502, 0210, 0208, 0209, 0206, 0207";

        String[] nowBusinessScopeArr = str.split(",");
        List<String> nowBusinessScopeList = Arrays.asList(nowBusinessScopeArr);
        List<String> nowBusinessScopeListHandle = new ArrayList<>();
        for(int i=0;i<nowBusinessScopeList.size();i++){
           String scope = nowBusinessScopeList.get(i);
           nowBusinessScopeListHandle.add(scope.trim());
        }

        Map<String,List<String>> supAndSubBusinessScopeMap = new HashMap<>();
        List<String> sub020501 = new ArrayList<>();
        sub020501.add("02050101");
        supAndSubBusinessScopeMap.put("020501",sub020501);


        List<String> sub0205 = new ArrayList<>();
        sub0205.add("020501");
        sub0205.add("020502");
        sub0205.add("020503");
        sub0205.add("020504");
        sub0205.add("020505");
        sub0205.add("020506");
        supAndSubBusinessScopeMap.put("0205",sub0205);


        List<String> sub02 = new ArrayList<>();
        sub02.add("0201");
        sub02.add("0202");
        sub02.add("0203");
        sub02.add("0204");
        sub02.add("0205");
        sub02.add("0206");
        sub02.add("0207");
        sub02.add("0208");
        sub02.add("0209");
        sub02.add("0210");
        sub02.add("0211");
        sub02.add("0212");
        sub02.add("0213");
        sub02.add("0214");
        sub02.add("0215");
        sub02.add("0216");
        supAndSubBusinessScopeMap.put("02",sub02);



        List<String> result = mergeBusinessScope(nowBusinessScopeListHandle, supAndSubBusinessScopeMap, 6, 0);

        System.out.println(Arrays.toString(result.toArray()));

    }

    public static void test(){

        String str = "13020409, 13020408, 13031306, 130317, 13031305, 13031308, 13031307, 13031302, 13031301, 13031304, 13031303, 13031309, 13020407, 13020406, 13020405, \n" +
                "13020404, 13020403, 13020402, 13020401, 13021610, 13030101, 13021609, 13021608, 13021607, 13030107, 13030106, 13030109, 13030901, 13030108, 13030103,\n" +
                " 13030102, 13030105, 13030104, 13030907, 13030906, 13030903, 13030902, 13030905, 13030904, 13021606, 13021605, 13021604, 13021603, 13021602, 13021601,\n" +
                "  13020309, 13031404, 13031401, 13031403, 13031402, 13020308, 13020307, 13020306, 13020305, 13020304, 13020303, 13020302, 13020301, 130222, 13030205, \n" +
                "  13030202, 13030201, 13030204, 13030203, 13020410, 13021507, 13021506, 13021505, 13020415, 13021504, 13020414, 13021503, 13020413, 13021502, 13020412,\n" +
                "   13021501, 13020411, 13020609, 13020608, 13020607, 13020606, 13031504, 13031503, 13031505, 13031502, 13031501, 13022105, 13022106, 13022107, 13022108, \n" +
                "   13022109, 13020605, 13020604, 13020603, 13020602, 13022101, 13020601, 13022102, 13022103, 13022104, 13030305, 13030304,\n" +
                " 13030301, 13030303, 13030302, 13021004, 13021003, 13021002, 13021001, 13021804, 13021803, 13021802, 13021801, 13020710, 13021005, 13031603, 13031602, \n" +
                " 13031604, 13031601, 13022006, 13022001, 13022002, 13020501, 13022003, 13022004, 13022005, 13021707, 13021706, 13030404, 13030403, 13030402, 13030401, \n" +
                " 13021705, 13021704, 13022110, 13020614, 13021703, 13022111, 13020613, 13021702, 13022112, 13020612, 13021701, 13022113, 13020611, 13022114, 13020610, \n" +
                " 13020806, 13020805, 13020804, 13030612, 13030611, 13030610, 13020803, 13020802, 13020801, 13030503, 13030502, 13030504, 13030501, 13021202, 13021201, \n" +
                " 13021204, 13021203, 13031001, 13031003, 13031002, 13020709, 13020708, 13020707, 13020706, 13020705, 13031801, 13031802, 13031005, 13031004, 13031006, \n" +
                " 13020704, 13020703, 13020702, 13020701, 13030602, 13030601, 13030604, 13\n" +
                "13021103, 13030609, 13021102, 020506, 13021101, 020505, 020504, 13030606, 020503, \n" +
                "13030605, 020502, 13030608, 13030607, 13021903, 13021902, 13021901, 13021105, 13021104, \n" +
                "13031102, 13031101, 13031902, 13031901, 13031104, 13031103, 0204, 13020201, 0202, 0203, 13031904, 0201, 13031903, 13020209, 13020208, 13020207, 13020206, \n" +
                "0208, 13020205, 0209, 13020204, 0206, 13020203, 0207, 13020202, 13030701, 13030703, 13030702, 0215, 13020311, 0216, 13020310, 0213, 0214, 0211, 1301, \n" +
                "13030705, 0212, 13030704, 0210, 13021406, 13021405, 13021404, 13020314, 13021403, 13020313, 13021402, 13020312, 13021401, 13031201, 13020908, 13020907, \n" +
                "13020906, 13020905, 13020904, 13020903, 13031207, 13031206, 13031209, 13031208, 13031203, 13031202, 13031205, 13031204, 13020102, 13021312, 13020101, \n" +
                "13021311, 13021310, 02050101, 13020902, 13020901, 13020106, 13020105, 13020104, 13021314, 13020103, 13021313, 13031210, 13031211, 13030802, 13030801,\n" +
                " 13020212, 13021301, 13020211, 13020210, 13030804, 13030803, 13030805, 13021309, 13021308, 13021307, 13021306, 13021305, 13021304, 13020214, 13021303, \n" +
                " 13020213, 13021302";

        String[] nowBusinessScopeArr = str.split(",");
        List<String> nowBusinessScopeList = Arrays.asList(nowBusinessScopeArr);
        List<String> nowBusinessScopeListHandle = new ArrayList<>();
        for(int i=0;i<nowBusinessScopeList.size();i++){
            String scope = nowBusinessScopeList.get(i);
            nowBusinessScopeListHandle.add(scope.trim());
        }

        //


    }




    /**
     * 合并原经营简码:如果经营简码的子简码都存在，那么就以父简码代替子简码
     * @param nowBusinessScopeList  需要合并的经营简码
     * @param supAndSubBusinessScopeMap 父经营简码->子经营简码List  键值对
     * @param maxLengthBusinessScope 要合并的经营简码最长的长度
     * @param times 合并次数
     * @return
     */
    public static List<String> mergeBusinessScope(List<String> nowBusinessScopeList, Map<String,List<String>> supAndSubBusinessScopeMap,
                                                  Integer maxLengthBusinessScope, Integer times){
        //合并次数不超过最长经营简码/2,也就是不超过最多的层级,比如4层，最多合并3次
        if(times >= maxLengthBusinessScope/2){
            return nowBusinessScopeList;
        }
        times = times+1;
        //存放父经营简码->子经营简码List
        Map<String,List<String>> superBusinessScopeMap = new HashMap<>();
        //找父经营简码
        for(int i=0;i<nowBusinessScopeList.size();i++){
            //经营简码
            String businessScope = nowBusinessScopeList.get(i);
            //顶级经营简码
            if(businessScope == null || businessScope.length() <= 2){
                continue;
            }
            //父经营简码(直接父经营简码)
            String superBusinessScope = businessScope.substring(0,businessScope.length()-2);
            //查询该父经营简码的子简码列表
            List<String> businessScopeList = superBusinessScopeMap.get(superBusinessScope);
            if(businessScopeList == null){
                businessScopeList = new ArrayList<>();
            }
            //添加该子简码
            businessScopeList.add(businessScope);
            //更新存放map
            superBusinessScopeMap.put(superBusinessScope, businessScopeList);
        }
        //根据key的长度倒序
        superBusinessScopeMap = sortByMapKeyLength(superBusinessScopeMap);
        //如果子经营简码都存在，那么去掉自营简码，增加父简码替代
        for(Map.Entry<String,List<String>> entry : superBusinessScopeMap.entrySet()){
            String superBusinessScope = entry.getKey();
            //子经营简码
            List<String> subBusinessScopeList = entry.getValue();
            //原始的子经营简码
            List<String> originSubBusinessScopeList = supAndSubBusinessScopeMap.get(superBusinessScope);
            if(subBusinessScopeList != null && subBusinessScopeList.size() > 0 && originSubBusinessScopeList != null && originSubBusinessScopeList.size() > 0){
                String subBusinessScopeStr = subBusinessScopeList.stream().sorted().collect(Collectors.joining(","));
                String originSubBusinessScopeStr = originSubBusinessScopeList.stream().sorted().collect(Collectors.joining(","));
                if(subBusinessScopeStr.equals(originSubBusinessScopeStr)){
                    //移除子经营简码
                    nowBusinessScopeList = remove(nowBusinessScopeList, subBusinessScopeList);
                    //增加父经营简码
                    nowBusinessScopeList.add(superBusinessScope);
                }
            }
        }
        nowBusinessScopeList = mergeBusinessScope(nowBusinessScopeList, supAndSubBusinessScopeMap, maxLengthBusinessScope, times);
        return nowBusinessScopeList;
    }

    /**
     * 移除子集合: 从listA移除listB
     * @param listA
     * @param listB
     * @return
     */
    public static List<String> remove(List<String> listA,List<String> listB){
        List<String> newList = new ArrayList<>(listA);
        for(int i=0; i< listB.size() ; i++){
            newList.remove(listB.get(i));
        }
        return newList;
    }

    public static Map<String,List<String>> sortByMapKeyLength(Map<String,List<String>> superBusinessScopeMap){
        Map<String,List<String>> sortedMap = superBusinessScopeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(String::length).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

}
