package swea.d2;

import java.util.Scanner;

public class swea1859 {

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();        
		for(int test_case = 1; test_case <= T; test_case++)		{
			int N = sc.nextInt();
			int []a =new int [N];
			long result=0;
			for(int i =0 ;i<N;i++) {
				a[i] = sc.nextInt();
			}
			int max = a[N-1];

			for(int i =N-2;i>=0;i--) {                
				if(max > a[i]){
					result += max-a[i];
				}else{
					max = a[i];
				}           
			}
			System.out.println("#" + test_case + " " +result);
		}
	}

}
