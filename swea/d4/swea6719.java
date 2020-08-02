package swea.d4;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 6719. 성수의 프로그램 강좌 시청
 */
public class swea6719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<=T;t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] a = new int[N];
			for(int i = 0;i<N;i++) {
				a[i] = sc.nextInt();
			}
			
			double result =0;
			
			Arrays.sort(a);
			for(int i=N-K;i<N;i++) {
				result = (result+a[i])/2;				
			}
			System.out.printf("#%d %f\n",t,result);
		}
	}
}
