package cn.xiaojiaqi.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution212 {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new LinkedList<>();
        
        for(int i=0;i<words.length;i++){
            if(findWord(board,words[i]))list.add(words[i]);
        }
        return list;
        
    }
    public static boolean findWord(char[][] board,String word){
        char[] wch = word.toCharArray();
        boolean[][] flag = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(findWord(board,wch,0,flag,i,j))return true;
            }
        }
        return false;
    }
    public static boolean findWord(char[][] board,char[] wch,int begin,boolean[][] flag,int i,int j){
        if(begin>=wch.length)return true;
        if(i<board.length&&i>-1&&j>-1&&j<board[0].length){
            if(flag[i][j]==false&&board[i][j]==wch[begin]){
                flag[i][j]=true;
                boolean p = findWord(board,wch,begin+1,flag,i+1,j);
                if(p)return true;
                p = findWord(board,wch,begin+1,flag,i-1,j);
                if(p)return true;
                p = findWord(board,wch,begin+1,flag,i,j+1);
                if(p)return true;
                p = findWord(board,wch,begin+1,flag,i,j-1);
                if(p)return true;
                flag[i][j]=false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		List<String> list = findWords(board, words);
		System.out.println(list);
		
		Set<String> set = new HashSet<>(list);		
	}
}