import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 알약
 * https://www.acmicpc.net/problem/4811
 */
public class baek4811 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		
		long[][] dp = new long[30+1][30+1];
		for(int h = 0 ; h<=30;h++) {
			for(int w =0;w<=30;w++) {
				if(h>w) {
					continue;
				}
				if(h==0) {
					dp[w][h] = 1;
				}else {
					dp[w][h] = dp[w-1][h] + dp[w][h-1];
				}
			}
		}
		
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) {
				break;
			}
			answer.append(String.valueOf(dp[N][N])).append("\n");
		}
		System.out.println(answer.toString());
	}
}
