package cn.xiaojiaqi.leetcode;
public class Leetcode_208_Implement_Trie_Prefix_Tree {
	
}
class TrieNode{
	int end;
    int path;
    TrieNode[] paths;
    public TrieNode() {
    	end = 0;
    	path = 0;
    	paths = new TrieNode[26];
    }
}
class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        TrieNode p = root;
        for(int i=0;i<words.length;i++){
            if(p.paths[words[i]-'a']==null){
            	TrieNode trie = new TrieNode();
                p.paths[words[i]-'a'] = trie;
            }
            p.path++;
            p = p.paths[words[i]-'a'];
        }
        p.end++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        TrieNode p = root;
        for(int i=0;i<words.length;i++){
            if(p.paths[words[i]-'a']==null){
                return false;
            }
            p = p.paths[words[i]-'a'];
        }
        return p.end>0 ? true : false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TrieNode p = root;
        for(int i=0;i<words.length;i++){
            if(p.paths[words[i]-'a']==null){
                return false;
            }
            p = p.paths[words[i]-'a'];
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */