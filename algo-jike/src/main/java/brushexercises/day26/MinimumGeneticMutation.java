package brushexercises.day26;

import java.util.*;

/**
 * @Describe : leetcode:433. 最小基因变化【没有搞懂】
 * @Author : sunzhenning
 * @Since : 2022/6/24 16:11
 */
public class MinimumGeneticMutation {

    /**
     * 思路：前提:(1)基因由四个字母构成，‘A’, ‘C’, ‘G’, ‘T’，(2)一次变化只有一个字符不同，(3)A基因变成B的过程中，B一定在基因库bank中
     * 1.（1）如果start和end相同，直接返回0，因为没有变化；（2）如果最终的基因序列不在bank中，则返回-1，根本找不到；（3）找到了返回最小次数
     * 2.比如基因AACCGGTA,变化一个字母的情况，存在3*8中情况，因为每个字母会变成另外三个字母。所以是3*8
     * 3.(1)校验变化的合法性，只有存在bank的字母才是合法的，否则变化直接丢弃;(2)我们还需要使用hash表记录是否已经遍历过的基因，如果该基因已经遍历过，则直接跳过
     * （3）如果合法并且未遍历过的基因，加入队列中
     * 4.如果变化后的基因与end相等，我们返回最小次数即可，如果队列中所有元素都已经遍历完成还无法变成end,则此时无法实现目标变化，返回-1;
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        //开始和结束相等，直接结束，0步完成
        if(start.equals(end)){
            return 0;
        }
        for(String bankElement : bank){
            bankSet.add(bankElement);
        }
        //给出的end就是不合法的，直接返回-1，结束
        if(!bankSet.contains(end)){
            return -1;
        }
        //遍历过的基因放到visited中
        Set<String> visited = new HashSet<>();
        visited.add(start);
        //创建一个队列，存放没有遍历过的合法的基因
        Queue<String> queue = new ArrayDeque<>();
        char[] keys = {'A','C','G','T'};
        queue.add(start);
        int step = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0;i<sz;i++){
                //队列中出列的基因字符串
                String curr = queue.poll();
                for(int j=0;j<8;j++){
                    for(int k=0;k<4;k++){
                        if(keys[k] != curr.charAt(j)){
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && bankSet.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
