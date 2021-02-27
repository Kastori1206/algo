package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 구간 곱 구하기
 * https://www.acmicpc.net/problem/11505
 */
public class baek11505 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long mod = 1_000_000_007;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] dp = new long[N+1];
		dp[0] = 1;
		long mul = 1;
		for(int i =1;i<=N;i++) {
			mul *= Integer.parseInt(st.nextToken());
			dp[i] = mul;
		}
	}
}