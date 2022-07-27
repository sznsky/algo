package brushexercises.day58;

import java.util.HashMap;
import java.util.Map;

/**
 * Day58：字符串转换整数 (atoi)-8
 */
public class NO_8_StringToIntegerAtoi {

    /**
     * 思路：状态机
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for(int i=0;i<length;i++){
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }

    /**
     * 自动机：有限状态机
     */
    class Automaton{
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        /**
         * 根据字符获取
         * @param c
         */
        public void get(char c){
            //根据字符获取状态
            state = table.get(state)[getCol(c)];
            if("in_number".equals(state)){
                ans = ans * 10 + c - '0';
                ans = sign ==1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            }else if("signed".equals(state)){
                sign = c == '+' ? 1 : -1;
            }
        }

        /**
         * 对于可能出现的字符情况，数字化
         * @param c
         * @return
         */
        private int getCol(char c){
            //空格
            if(c == ' '){
                return 0;
            }
            if(c == '+' || c == '-'){
                return 1;
            }
            //数字
            if(Character.isDigit(c)){
                return 2;
            }
            //其他的
            return 3;
        }

    }
}
