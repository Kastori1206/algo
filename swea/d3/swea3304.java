package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3304. 최장 공통 부분 수열
 */
public class swea3304 {
    static int[][] LCS;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();

            int R = a.length;
            int C = b.length;
            LCS = new int[R + 1][C + 1];

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (a[i - 1] == b[j - 1]) {
                        LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    } else {
                        LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                    }
                }
            }
            sb.append(String.format("#%d %d\n", t, LCS[R][C]));

        }
        System.out.println(sb);
    }
}
