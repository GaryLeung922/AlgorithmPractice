package cn.xiaojiaqi.leetcode;

/**
 * 211. Add and Search Word - Data structure design
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liangjiaqi
 * @Date: 2020/6/25 4:49 PM
 */
public class LeetCode_211_Add_and_Search_Word_Data_structure_design {

    public Node node;

    public static void main(String[] args) {
        char a = 'a';
        System.out.println('z'-'a');
    }

    public LeetCode_211_Add_and_Search_Word_Data_structure_design() {
        this.node = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word ==null && word.length()<=0){
            return;
        }
        char[] chars = word.toCharArray();

        Node cur = this.node;

        for(int i=0;i<chars.length;i++){
            if(cur.nexts[chars[i]-97]==null){
                cur.nexts[chars[i]-97] = new Node();
            }
            cur.path++;
            cur = cur.nexts[chars[i]-97];
        }
        cur.end++;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null || word.length() <=0)return false;
        return search(word.toCharArray(),0,this.node);
    }

    public boolean search(char[] word,int left, Node root){
        if(word==null || left >word.length || root==null)return false;
        if(left == word.length)return root.end==0 ? false : true;

        Node cur = root;
        for(int i=left;i<word.length;i++){
            if(word[i]=='.'){
                for(int j=0;j<26;j++){
                    if(cur.nexts[j]!=null && search(word,i+1,cur.nexts[j]))return true;
                }
                return false;
            }else if(cur.nexts[word[i]-97]==null){
                return false;
            }else {
                cur = cur.nexts[word[i]-97];
            }
        }

        return cur.end==0 ? false : true;
    }

    static class Node{
        public Node[] nexts;
        public int end;
        public int path;

        public Node() {
            this.nexts = new Node[26];
        }
    }

}
