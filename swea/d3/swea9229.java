package swea.d3;

import java.util.Scanner;

public class swea9229{
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int N, M, result;
		int[] data;		
		
		for(int test_case = 1; test_case <= T; test_case++){
			result = -1;
			N = sc.nextInt();
			M = sc.nextInt();
			data = new int[N];
			
			for(int i =0;i<N;i++) {
				data[i] = sc.nextInt();
			}
			for(int i =0;i<N;i++) {
				for(int j = 0; j<N;j++) {
					if(i==j) {
						continue;
					}
					if(M< data[i]+data[j]) {
						continue;
					}
					result = Math.max(result, data[i]+data[j]);
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}