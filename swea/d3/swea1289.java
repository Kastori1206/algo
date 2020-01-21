package swea.d3;

import java.util.Scanner;

public class swea1289{
	public static void main(String args[]) throws Exception{		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0;
			String num = sc.next();
			String []arr = num.split("");			

			if(arr[0].equals("1")) {
				cnt++;
			}
			for(int i=1;i<arr.length;i++) {
				if(!arr[i].equals(arr[i-1]) ) {
					cnt++;					
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}
}
