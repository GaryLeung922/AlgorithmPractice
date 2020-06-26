package cn.xiaojiaqi.leetcode;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @Author: liangjiaqi
 * @Date: 2020/6/25 8:00 PM
 */
public class LeetCode_212_Word_Search_2 {


    /**
     * 解法一： 回溯+记忆表 暴力
     * 用set和boolean[][] 差别是，一个超时，一个514ms
     * 对于单个字符串来说，时间复杂度O(n*m*len(word)) 空间复杂度O(n*m)
     * n=board.length m=board[0].length
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if(board==null || board.length==0 || board[0].length==0 || words==null || words.length==0){

            return new LinkedList<String>(result);
        }
        for(int i=0;i<words.length;i++){
            findWords(board,words[i],result);
        }
        return new LinkedList<String>(result);


    }

    public void findWords(char[][] board,String word,Set<String> result){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j] && help(board,i,j,word.toCharArray(),0,result,new boolean[board.length][board[0].length])){
                    return;
                }
            }
        }
    }


    public boolean help(char[][] board,int n, int m,char[] chars, int i,Set<String> result,boolean[][] flags){
        if(n>=board.length || n<0 || m<0 || m>=board[0].length || board[n][m]!=chars[i] || flags[n][m] ){
            return false;
        }
        if(i==chars.length-1){
            result.add(String.valueOf(chars));
            return true;
        }
        flags[n][m]=true;
        if(help(board,n+1,m,chars,i+1,result,flags)){
            return true;
        }
        if(help(board,n-1,m,chars,i+1,result,flags)){
            return true;
        }
        if(help(board,n,m+1,chars,i+1,result,flags)){
            return true;
        }
        if(help(board,n,m-1,chars,i+1,result,flags)){
            return true;
        }
        flags[n][m]=false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}
        };
        String[] strs = new String[]{
                "oath","pea","eat","rain"
        };

        LeetCode_212_Word_Search_2 c = new LeetCode_212_Word_Search_2();
        List<String> words = c.findWords(board, strs);

        char[][] board2 = new char[][]{
                {'a'}
        };
        String[] strs2 = new String[]{
                "a"
        };

        List<String> words2 = c.findWords2(board2, strs2);
        System.out.println(words2);
    }

    /**
     * 解法二：字典树🌲+回溯
     * 一定是对input(words)做字典树
     *
     * 优化：
     * 一：沿着 Trie 的节点回溯。
     * 二：在回溯过程中逐渐剪除 Trie 中的叶子节点（剪枝）。
     * 三：从 Trie 中删除匹配的单词。
     *
     * 时间复杂度：O(M(4⋅3^(L−1)))
     *  其中MM 是二维网格中的单元格数，LL 是单词的最大长度。
     * 空间复杂度：O(N)，其中 N 是字典中的字母总数
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Node{
        public String end;
        public Node[] nexts;

        public Node(){
            nexts = new Node[26];
        }

    }

    private Node root = new Node();

    public List<String> findWords2(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if(words==null || words.length<1 || board == null || board.length<1||board[0].length<1){
            return result;
        }
        for(String word: words){
            addWords(word);
        }
        Node cur = this.root;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(cur.nexts[board[i][j]-97] != null){
                    helpFind1(board,i,j,cur,new boolean[board.length][board[0].length], result);
                }
            }
        }
        return result;
    }

    // 两种helpFind都可以
    public boolean helpFind1(char[][] board,int i,int j,Node root,boolean[][] flag,List<String> res){
        if(root.end != null && !root.end.equals("")){
            res.add(root.end);
            root.end = null;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||flag[i][j]){
            return false;
        }

        if(root.nexts[board[i][j]-97]!=null){
            root = root.nexts[board[i][j]-97];
            flag[i][j] = true;
            if(helpFind1(board,i-1,j,root,flag,res)){
                return true;
            }
            if(helpFind1(board,i+1,j,root,flag,res)){
                return true;
            }
            if(helpFind1(board,i,j-1,root,flag,res)){
                return true;
            }
            if(helpFind1(board,i,j+1,root,flag,res)){
                return true;
            }
            flag[i][j] = false;
        }
        return false;

    }

    public void helpFind2(char[][] board,int i,int j,Node root,boolean[][] flag,List<String> res){
        if(root.end != null && !root.end.equals("")){
            res.add(root.end);
            root.end = null;
            if(i<0||i>=board.length||j<0||j>=board[0].length||flag[i][j]){
                return ;
            }
            if(root.nexts[board[i][j]-97]==null){
                return ;
            }
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||flag[i][j]){
            return ;
        }

        if(root.nexts[board[i][j]-97]!=null){
            root = root.nexts[board[i][j]-97];
            flag[i][j] = true;
            helpFind2(board,i-1,j,root,flag,res);
            helpFind2(board,i+1,j,root,flag,res);
            helpFind2(board,i,j-1,root,flag,res);
            helpFind2(board,i,j+1,root,flag,res);
            flag[i][j] = false;
        }
        return ;

    }

    /**
     * 构建字典树
     * @param str
     */
    public void addWords(String str){
        char[] chars = str.toCharArray();

        Node cur = this.root;
        for(int i=0;i<chars.length;i++){
            if(cur.nexts[chars[i]-97]==null){
                cur.nexts[chars[i]-97] = new Node();
            }
            cur = cur.nexts[chars[i]-97];
        }

        //存储单词
        cur.end = str;
    }
}
