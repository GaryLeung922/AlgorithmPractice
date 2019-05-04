package cn.xiaojiaqi.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordFilter {
    TrieNode preRoot;
    TrieNode sufRoot;
    
    public WordFilter(String[] words) {
        TrieNode[] res = generateTrie(words);
        preRoot = res[0];
        sufRoot = res[1];
    }
    
    public int f(String prefix, String suffix) {
        TrieNode p = preRoot;
        TrieNode s = sufRoot;
        boolean flag = false;
        List<Integer> pre;
        List<Integer> suf;
        for(int i=0;i<prefix.length();i++){
        	char c = prefix.charAt(i);
            if(p.next[c-'a']==null){
                flag = true;
            }
            if(flag)return -1;
            p = p.next[c-'a'];
        }
        pre = p.pass;
        for(int i=suffix.length()-1;i>-1;i--){
        	char c = suffix.charAt(i);
            if(s.next[c-'a']==null){
                flag = true;
            }
            if(flag)return -1;
            s = s.next[c-'a'];
        }
        suf = s.pass;
        
        int max = -1;
        Set<Integer> set = new HashSet<>(pre);
        for(int i=0;i<suf.size();i++){
            if(set.contains(suf.get(i))){
                max = Math.max(max,suf.get(i));
            }
        }
        return max;
        
    }
    public TrieNode[] generateTrie(String[] words){
        TrieNode preRoot = new TrieNode();
        TrieNode sufRoot = new TrieNode();
        TrieNode p = preRoot;
        TrieNode s = sufRoot;
        for(int j=0;j<words.length;j++){
            preRoot.pass.add(j);
            sufRoot.pass.add(j);
        }
        for(int j=0;j<words.length;j++){
            char[] chs = words[j].toCharArray();
            preRoot = p;
            sufRoot = s;
            for(int i=0;i<chs.length;i++){
                char c = chs[i];
                if(preRoot.next[c-'a']==null){
                    preRoot.next[c-'a'] = new TrieNode();
                    //preRoot.pass.add(i);
                }
                preRoot = preRoot.next[c-'a'];
                preRoot.pass.add(j);
            }
            for(int i=chs.length-1;i>-1;i--){
                char c = chs[i];
                if(sufRoot.next[c-'a']==null){
                    sufRoot.next[c-'a'] = new TrieNode();
                }   
                sufRoot = sufRoot.next[c-'a'];
                sufRoot.pass.add(j);
            }
        }
        return new TrieNode[]{p,s};
    }
    public static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        List<Integer> pass = new LinkedList<>();
        
    } 
    public static void main(String[] args) {
    	String[] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
    	String prefix = "bccbacbcba";
    	String suffix = "a";
    	WordFilter obj = new WordFilter(words);
    	int param_1 = obj.f(prefix,suffix);
    	System.out.println(param_1);
    	
    	System.out.println((int)'a');
	}
}


/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */