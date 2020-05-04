package cn.xiaojiaqi.leetcode;

//岛问题：
//经典的岛问题,可以用感染函数解决(DFS)
//大数据的岛问题,用并行计算+并查集
public class LeetCode_200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)return 0;
        
        int island = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    island++;
                    infect(grid,i,j);
                }
            }
        }
        return island;
    }
    public void infect(char[][] grid,int i,int j){
        if(i<grid.length&&j<grid[0].length&&i>=0&&j>=0&&grid[i][j]=='1'){
            grid[i][j]='2';
            infect(grid,i-1,j);
            infect(grid,i+1,j);
            infect(grid,i,j-1);
            infect(grid,i,j+1);
        }
    }
    public static void main(String[] args) {
		String s = "asdf";
		
	}
}