package week2.task;

import java.util.*;

/**
 * @Describe : leetcode:811 【子域名访问计数】
 * @Author : sunzhenning
 * @Since : 2022/6/7 10:22
 * 思路：1.拆分域名存入map：例如50 google.mail.com 将"com":50 "mail.com":50，"google.mail.com":50 存入map
 * 2.put之前判断是否已经存在，存在就累加次数
 */
public class SubdomainVisitCount {

    public static void main(String[] args) {
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = subdomainVisitCount.subdomainVisits(cpdomains);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<cpdomains.length;i++){
           String cpdomain = cpdomains[i];
           String[] cpdomainArr = cpdomain.split(" ");
           Integer count = Integer.valueOf(cpdomainArr[0]);
           String domainName = cpdomainArr[1];
           String[] domainNameArr = domainName.split("\\.");
            String str = "";
           for(int j= domainNameArr.length-1; j>=0; j--){
               String childDomainName = domainNameArr[j];
               if("".equals(str)){
                   str = childDomainName;
               }else{
                   str = childDomainName+"."+str;
               }
               if(map.containsKey(str)){
                   int countNew = map.get(str);
                   map.put(str, countNew+count);
               }else{
                   map.put(str, count);
               }
           }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();
            String an = value+" "+key;
            ans.add(an);
        }
        return ans;
    }







}
