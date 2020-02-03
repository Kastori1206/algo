package swea.d3;

import java.util.Scanner;

public class swea1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;

		for(int test_case = 1; test_case <= 10; test_case++){
			T=sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(String.format("#%d %d", T, power(N,M)));

		}
	}
	static int power(int base, int exp) {
		if(exp == 1) {
			return base;
		}
		if(exp == 0) {
			return 1;
		}		
		int num = power(base,exp/2);
		
		if(exp % 2 == 0) {
			return num * num;
		}else {
			return num * num * base;
		}		
	}
}
