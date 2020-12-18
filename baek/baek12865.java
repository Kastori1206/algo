package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 평범한 배낭
 * https://www.acmicpc.net/problem/12865
 * DP
 */
public class baek12865 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N];
        int[] V = new int[N];
        int[][] dp = new int[N+1][K+1];
        int max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(W[i-1] <= j) {
                    dp[i][j] = Math.max(V[i - 1] + dp[i - 1][j - W[i - 1]], dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
//    static void print(int[][] dp, int N, int K){
//        for (int i =0;i<=N;i++){
//            for(int j =0;j<=K;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
}
