package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 크리보드
 * https://www.acmicpc.net/problem/11058
 */
public class baek11058 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[100+1];

        for(int i =1 ; i<=N;i++){
            dp[i] = i;
        }
        for(int i = 6; i <=N;i++){
            dp[i] = Math.max(dp[i-3]*2, Math.max(dp[i-4]*3, dp[i-5]*4));
        }

        System.out.println(dp[N]);
    }
}
