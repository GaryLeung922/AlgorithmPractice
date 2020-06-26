package cn.xiaojiaqi.leetcode;

/**
 *
 * @Author: liangjiaqi
 * @Date: 2020/6/26 12:23 PM
 */
public class LeetCode_079_Word_Search {

    /**
     * DFS+回溯。 如果原board不能修改，则需要另外开辟flags的空间
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word==null||word.length()==0)return false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && help(board, i,j,word.toCharArray(), 0, new boolean[board.length][board[0].length])){
                    return true;
                }
            }
        }

        return false;
    }


    public boolean help(char[][] board, int i,int j,char[] chars, int left, boolean[][] flags){
        if(left==chars.length)return true;

        if(i<0||i>=board.length||j<0||j>=board[0].length||flags[i][j])return false;

        if(chars[left]==board[i][j]){
            flags[i][j] = true;
            if(help(board,i+1,j,chars,left+1,flags))return true;
            if(help(board,i-1,j,chars,left+1,flags))return true;
            if(help(board,i,j+1,chars,left+1,flags))return true;
            if(help(board,i,j-1,chars,left+1,flags))return true;
            flags[i][j] = false;
        }
        return false;
    }
}
