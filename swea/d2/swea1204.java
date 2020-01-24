package swea.d2;

import java.util.Scanner;

public class swea1204 {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int result = 0;
		for(int test_case = 1; test_case <= T; test_case++){
			int num = sc.nextInt();
			int []a = new int[101];

			int max = 0;
			for(int i =0;i<1000;i++) {
				int score = sc.nextInt();
				a[score]++;
			}			
			for(int i=0;i<a.length;i++) {
				if(max<=a[i]) {
					max = a[i];					
					result = i;
				}
			}			
			System.out.println("#"+num+" "+ result);
		}
	}
}