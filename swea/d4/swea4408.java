package swea.d4;

import java.util.Scanner;
public class swea4408 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int max = Integer.MIN_VALUE;
			int N = sc.nextInt();
			int[] arr = new int[201];
			for(int i=0;i<N;i++) {
				int start= sc.nextInt();
				int end = sc.nextInt();				
				start = a(start);
				end = a(end);
				if(start>end) {
					int temp = start;
					start = end;
					end = temp;
				}
				
				for(int j = start/2;j<=end/2;j++ ) {
					arr[j]++;					
				}
				
			}
			
			for(int i=1;i<=200;i++) {
				if(max<arr[i]) {
					max =arr[i];
				}
			}			
			
			System.out.println(String.format("#%d %d", t,max));
		}//test_case
	}
	static int a(int n) {
		if(n%2!=0) {
			return n+1;
		}
		return n;
	}	
}
