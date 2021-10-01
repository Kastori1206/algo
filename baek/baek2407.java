package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 조합
 * https://www.acmicpc.net/problem/2407
 */
public class baek2407 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger[][] combi = new BigInteger[N + 1][N + 1];
        combi[1][0] = combi[1][1] = BigInteger.ONE;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    combi[i][j] = BigInteger.ONE;
                }else{
                    combi[i][j] = combi[i - 1][j - 1].add(combi[i - 1][j]);
                }
            }
        }
        System.out.println(combi[N][M]);

    }
}
