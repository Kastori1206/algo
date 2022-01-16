package codeforces.div2.round766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A. Not Shading
 * https://codeforces.com/contest/1627/problem/A
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            char[][] map = new char[n][m];
            int cnt = n * m;
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = temp.charAt(j);
                    if (map[i][j] == 'W') {
                        cnt--;
                    }
                }
            }

            if (cnt == 0) {
                answer.append(-1);
            } else if (map[r][c] == 'B') {
                answer.append(0);
            } else {
                boolean flag = false;
                for (int i = 0; i < m; i++) {
                    if (map[r][i] == 'B') {
                        flag = true;
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (map[i][c] == 'B') {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    answer.append(1);
                } else {
                    answer.append(2);
                }
            }

            answer.append("\n");
        }
        System.out.println(answer);
    }
}
