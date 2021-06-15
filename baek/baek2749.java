package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 피보나치 수 3
 * https://www.acmicpc.net/problem/2749
 * 피사노 주기(https://www.acmicpc.net/problem/9471) Wall 피보나치 수열 주기 성질
 * m > 2인 경우에 k(m)은 짝수이다.
 * 임의의 짝수 정수 n > 2에 대해서, k(m) = n인 m이 항상 존재한다.
 * k(m) ≤ m2 - 1
 * k(2n) = 3×2(n-1)
 * k(5n) = 4×5n
 * k(2×5n) = 6n
 * n > 2라면, k(10n) = 15×10(n-1)
 */
public class baek2749 {
	static final int MOD = 1_000_000;
	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		//위의 주기 성질에 의해 1500000 주기를 가짐
		N = N%1500000;
		long[] fibo = new long[(int) (N+1)];
		fibo[1] = 1;
		for(int i =2;i<=N;i++) {
			fibo[i] = (fibo[i-1]%MOD + fibo[i-2]%MOD)%MOD;
		}
		System.out.println(fibo[(int) N]);
	}
}
