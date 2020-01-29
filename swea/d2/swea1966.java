package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class swea1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int[] a = new int[N];
			
			for(int i=0;i<N;i++) {
				a[i] = sc.nextInt();
			}
			
			Arrays.sort(a);
			System.out.print("#"+test_case+" ");
			for(int i=0;i<N;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();			
		}
	}
}
