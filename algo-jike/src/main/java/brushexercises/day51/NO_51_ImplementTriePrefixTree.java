package brushexercises.day51;

/**
 * @Describe :208. 实现 Trie (前缀树)
 * @Author : sunzhenning
 * @Since : 2022/7/20 19:21
 */
public class NO_51_ImplementTriePrefixTree {

    public static void main(String[] args) {
        System.out.println('z'-'0');
        System.out.println('a'-'0');
        System.out.println('b'-'0');
        System.out.println('b'-'a');
    }

    private TrieNode root;

    class TrieNode{
        //是否结束（有效节点）
        boolean isEnd;
        //每个TrieNode节点，有26个子孩子
        TrieNode[] children;
        //构造方法初始化
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    public NO_51_ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char c : prefix.toCharArray()){
            int i = c - 'a';
            if(p.children[i] == null){
                return false;
            }
            p = p.children[i];
        }
        return true;
    }
}
