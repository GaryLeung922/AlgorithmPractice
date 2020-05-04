package cn.xiaojiaqi.sword2Offer;

public class NinePointLockScreen {

	

	private static int walks(int[][] mat, int i, int j, int k){
		
		//int res = k>=4 ? 1 :0;
		if(i>=0&&i<3&&j>=0&&j<3) {
			if(mat[i][j]==0) {
				if(k==4)return 1;
				
				mat[i][j]=1;
				int p1 = 0;
				if(i+1>=0&&i+1<3&&j>=0&&j<3) {
					p1 = mat[i+1][j]==0 ? walks(mat,i+1,j,k+1) : walks(mat,i+2,j,k+1);
				}
				int p2=0;
				if(i-1>=0&&i-1<3&&j>=0&&j<3) {
					p2 = mat[i-1][j]==0 ? walks(mat,i-1,j,k+1) : walks(mat,i-2,j,k+1);
				}
				int p3=0;
				if(i>=0&&i<3&&j+1>=0&&j+1<3) {
					p3 = mat[i][j+1]==0 ? walks(mat,i,j+1,k+1) : walks(mat,i,j+2,k+1);
				}
				int p4=0;
				if(i>=0&&i<3&&j-1>=0&&j-1<3) {
					p4 = mat[i][j-1]==0 ? walks(mat,i,j-1,k+1) : walks(mat,i,j-2,k+1);
				}
				int p5=0;
				if(i+1>=0&&i+1<3&&j+1>=0&&j+1<3) {
					p5 = mat[i+1][j+1]==0 ? walks(mat,i+1,j+1,k+1) : walks(mat,i+2,j+2,k+1);
				}
				int p6=0;
				if(i-1>=0&&i-1<3&&j-1>=0&&j-1<3) {
					p6 = mat[i-1][j-1]==0 ? walks(mat,i-1,j-1,k+1) : walks(mat,i-2,j-2,k+1);
				}
				int p7=0;
				if(i+1>=0&&i+1<3&&j-1>=0&&j-1<3) {
					p7 = mat[i+1][j-1]==0 ? walks(mat,i+1,j-1,k+1) : walks(mat,i+2,j-2,k+1);
				}
				int p8=0;
				if(i-1>=0&&i-1<3&&j+1>=0&&j+1<3) {
					p8 = mat[i-1][j+1]==0 ? walks(mat,i-1,j+1,k+1) : walks(mat,i-2,j+2,k+1);
				}
				
				int p9 = walks(mat,i+1,j+2,k+1);
				int p10 = walks(mat,i-1,j+2,k+1);
				int p11 = walks(mat,i+1,j-2,k+1);
				int p12 = walks(mat,i-1,j-2,k+1);
				
				int p13 = walks(mat,i+2,j+1,k+1);
				int p14 = walks(mat,i-2,j+1,k+1);
				int p15 = walks(mat,i+2,j-1,k+1);
				int p16 = walks(mat,i-2,j-1,k+1);
				mat[i][j] = 0;
				
				return p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16;
			}else {
				int p1 = walks(mat,i+1,j,k);
				int p2 = walks(mat,i-1,j,k);
				int p3 = walks(mat,i,j+1,k);
				int p4 = walks(mat,i,j-1,k);
				
				int p5 = walks(mat,i+1,j+1,k);
				int p6 = walks(mat,i-1,j-1,k);
				int p7 = walks(mat,i+1,j-1,k);
				int p8 = walks(mat,i-1,j+1,k);
				
				int p9 = walks(mat,i+1,j+2,k);
				int p10 = walks(mat,i-1,j+2,k);
				int p11 = walks(mat,i+1,j-2,k);
				int p12 = walks(mat,i-1,j-2,k);
				
				int p13 = walks(mat,i+2,j+1,k);
				int p14 = walks(mat,i-2,j+1,k);
				int p15 = walks(mat,i+2,j-1,k);
				int p16 = walks(mat,i-2,j-1,k);
				return p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16;
			}
		}else {
			return 0;
		}
	}
	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		
		//System.out.println(Arrays.toString(mat[0]));
		int ans = walks(mat, 0, 0, 1);
		System.out.println(ans);
	}

}
