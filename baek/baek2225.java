package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 합분해
 * https://www.acmicpc.net/problem/2225
 * DP
 */
public class baek2225 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mod = 1000000000;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] d = new int[K+1][N+1];
		
		for(int i =1;i<=K;i++) {
			for(int j =0;j<=N;j++) {
				if(i==1) {
					d[i][j] = 1;
				}else if(j==0) {
					d[i][j] = 1;
				}else {
					d[i][j] = d[i-1][j]%mod + d[i][j-1]%mod;
				}				
			}
		}	
		
		System.out.println(d[K][N]%mod);
	}
}
