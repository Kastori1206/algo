package swea.d2;

import java.util.Scanner;

public class swea1948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		
		int[] d = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int test_case = 1; test_case <= T; test_case++){
			int[] a = new int[4];
			int r = 0;
			//입력
			for(int i =0;i<4;i++) {
				a[i] = sc.nextInt();
			}
			//첫 번째 달 에서 두 번째 달 전체 일수 구하기
			for(int i=a[0];i<a[2];i++) {
				r+=d[i];
			}
			//전체 일수 =  첫 번째 달 에서 두 번째 달 전체 일 - 첫 번째달의 날수 + 두 번째달의 날수 + 1  
			r = (r-a[1])+a[3]+1;
			System.out.println("#"+test_case+" "+r);		
		}
	}
}
