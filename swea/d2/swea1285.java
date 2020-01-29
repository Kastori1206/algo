package swea.d2;


import java.util.Scanner;

public class swea1285 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int TC  = sc.nextInt();
		
		for(int test_case = 1; test_case<=TC;test_case++) {
			int N = sc.nextInt();
			int[] a = new int[N];
			int min =  Integer.MAX_VALUE;
			int cnt =0;
			for(int i =0;i<N;i++) {
				a[i] = Math.abs(sc.nextInt());
				if(min >= a[i]) {
					min = a[i];
				}
			}
			for(int i =0;i<N;i++) {
				if(min == a[i]) {
					cnt++;
				}
			}			
			System.out.println(String.format("#%d %d %d", test_case,min,cnt));
		}
	}
}
