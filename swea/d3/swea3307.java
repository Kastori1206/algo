package swea.d3;

import java.util.Scanner;

public class swea3307 {
	public static void main(String args[]) throws Exception{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] d= new int[n];
			int answer = 1;
			for(int i = 0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i =0;i<n;i++) {
				d[i] = 1;
				for(int j = 0;j<=i;j++) {
					if(arr[i] > arr[j] && d[i] < d[j]+1 ) {
						d[i]=d[j]+1;                      
						answer = Math.max(answer, d[i]);
					}					
				}			
			}
			System.out.println("#"+ test_case + " " +answer );
		}
	}
}