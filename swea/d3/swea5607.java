package swea.d3;

import java.util.Scanner;

/*
 *  5607.페르마의 소정리
 */
public class swea5607 {
	private static final int MOD = 1234567891;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {			
			int n = sc.nextInt();
			int r = sc.nextInt();

			/*
			 * a^(p-2) = a^-1 (mod p)
			 * nCr = n!/r!(n-r)!
			 * n!*(r!(n-r!)^mod-2 =n!*(r!(n-r)!)^-1(%mod) 
			 */			

			//n!까지 구해서 배열에 저장
			long factorial[] = new long[n + 1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++) {
				factorial[i] = (factorial[i - 1] * i) % MOD;	
			}			
			//r!(n-r)!^mod-2			
			long left = power((factorial[r] * factorial[n - r]) % MOD, MOD - 2);			
			// n!*(r!(n-r!)^mod-2 = n!*left
			System.out.printf("#%d %d\n",t,(factorial[n] * left) % MOD);
		}
	}

	static long power(long base, int exp) {	
		if(exp==1){
			return base;
		}    
		if(exp == 0) {
			return 1;
		}
		long num = power(base,exp/2);
		long ret = (num * num)%MOD;
		if(exp % 2 == 0) {
			return ret;
		}else {
			return (ret*base)%MOD;
		}		
	}
}

