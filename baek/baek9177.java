package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 단어 섞기
 * https://www.acmicpc.net/problem/9177
 */
public class baek9177 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] strs = br.readLine().split(" ");
			int R = strs[0].length();
			int C = strs[1].length();
			for(String str : strs) {
				System.out.println(str);
			}
			boolean[][] dp = new boolean[R + 1][C + 1];
			dp[0][0] = true;
			for (int i = 1; i <= R; i++) {
				dp[i][0] = (strs[0].charAt(i - 1) == strs[2].charAt(i - 1)) ? dp[i - 1][0] : false;
			}
			for (int i = 1; i <= C; i++) {
				dp[0][i] = (strs[1].charAt(i - 1)) == strs[2].charAt(i - 1) ? dp[0][i - 1] : false;
			}
			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					char aa = strs[0].charAt(r - 1);
					char bb = strs[1].charAt(c - 1);
					char cc = strs[2].charAt(r + c - 1);
					if (aa != c && bb != cc) {
						dp[r][c] = false;
					} else if (aa == cc && bb != cc) {
						dp[r][c] = dp[r - 1][c];
					} else if (aa != cc && bb == cc) {
						dp[r][c] = dp[r][c - 1];
					} else {
						dp[r][c] = dp[r - 1][c] || dp[r][c - 1];
					}
				}
			}
			
			for(int r =0; r<=R;r++) {
				for(int c =0;c<=C;c++) {
					System.out.print(dp[r][c] +" ");
				}
				System.out.println();
			}
			if (dp[R][C]) {
				System.out.println("Data set " + (t + 1) + ": yes");
			} else {
				System.out.println("Data set " + (t + 1) + ": no");
			}
		}
	}
}
