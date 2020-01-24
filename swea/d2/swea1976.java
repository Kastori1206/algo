package swea.d2;

import java.util.Scanner;

public class swea1976 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] a = new int[4];
			for(int i=0;i<4;i++) {
				a[i] = sc.nextInt();
			}
			
			int m = a[1]+a[3];
			int h = a[0]+a[2]+m/60;
			if(h%12==0) {
				h=12;
			}else {
				h=h%12;
			}
			System.out.println("#"+test_case+" "+h+" "+m%60);
		}
	}

}
