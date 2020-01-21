package swea.d2;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE

public class swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,N,cnt,size,x,y,startX,startY,endX,endY, direction;
		T=sc.nextInt();		
		int [][]a;
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			a = new int[N][N];
			cnt = 1;			
			x = 0; y =0; startX = 0; startY = 0; endX=N-1; endY=N-1;
			direction = 0; // 우 하 좌 상
			for(int i =0 ;i<(N*N);i++) {				
				a[y][x] = cnt++;
				switch(direction) {
				case 0:
					if(x!=endX) {
						x++;
					}else {
						direction++;
						startY++;
						y++;
					}
					break;
				case 1:
					if(y!=endY) {
						y++;
					}else {
						direction++;
						endX--;
						x--;
					}
					break;
				case 2:
					if(x!=startX) {						
						x --;
					}else {
						direction++;
						endY--;
						y--;
					}
					break;
				case 3:
					if(y!=startY) {
						y--;
					}else {
						direction=0;
						startX++;
						x++;
					}
					break;
				}				
			}
			System.out.println("#"+test_case);
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
