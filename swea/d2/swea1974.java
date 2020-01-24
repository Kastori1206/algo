package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class swea1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)	{
			int[][]a = new int[9][9];
			
			for(int i=0;i<9;i++) {
				for(int j =0;j<9;j++) {
					a[i][j]=sc.nextInt();
				}
			}
			boolean[] chk = new boolean[10];// 인덱스 숫자 중복 체크 배열
			if(aa(chk,a)) {
				System.out.println("#"+test_case+" "+1);				 
			}else {
				System.out.println("#"+test_case+" "+0);				
			}				
		}		
	}
	public static boolean aa(boolean[] chk,int[][] a) {
		//가로검사
		for(int i=0;i<9;i++) {
			Arrays.fill(chk, false);
			for(int j=0;j<9;j++) {
				if(chk[a[i][j]]==true) {						
					return false;
				}
				chk[a[i][j]]=true;
			}
		}
		//세로검사
		for(int i=0;i<9;i++) {
			Arrays.fill(chk, false);
			for(int j=0;j<9;j++) {
				if(chk[a[j][i]]==true) {						
					return false;
				}
				chk[a[j][i]]=true;
			}
		}
		//구역 검사
		for(int i=0;i<9;i++) {				
			for(int j=0;j<9;j++) {					
				Arrays.fill(chk, false);					
				for(int k=0;k<3;k++) {
					for(int l=0;l<3;l++) {	
						if(chk[a[i+k][j+l]]==true) {						
							return false;
						}
						chk[a[i+k][j+l]]=true;
					}
				}
				j=j+2;	
			}
			i+=2;
		}
		return true;
	}
}


