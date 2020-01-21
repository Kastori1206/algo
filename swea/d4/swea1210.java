package swea.d4;

import java.util.Scanner;

public class swea1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int x = 0, y = 0;

		for(int test_case = 1; test_case <= 10; test_case++){
			int T;
			T=sc.nextInt();		

			int [][]a = new  int[100][100];
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[i].length;j++) {
					a[i][j] = sc.nextInt();
				}
			}

			for(int i=0;i<a.length;i++) {
				if(a[99][i] == 2) {
					x = i; y = 98;
					break;
				}				
			}

			while (y > 0) {
				if (isInBound(100, 100, y, x - 1) && a[y][x - 1] == 1) {
					// 왼쪽으로 이동
					while (isInBound(100, 100, y, x - 1) && a[y][x - 1] == 1) {
						x--;
					}
				} else if (isInBound(100, 100, y, x + 1) && a[y][x + 1] == 1) {
					// 오른쪽으로 이동
					while (isInBound(100, 100, y, x + 1) && a[y][x + 1] == 1) {
						x++;
					}
				}
				// 위로 한칸 전진
				y--;
			}
			System.out.println("#"+T+" "+x);
		}

	}
	public static boolean isInBound(int r, int c, int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}

}

