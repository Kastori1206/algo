package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 조립
 * https://www.acmicpc.net/problem/18116
 */
public class baek18116 {
    static int[] p, cnt;
    static final int MAX = 1000000 + 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        p = new int[MAX];
        cnt = new int[MAX];

        //부모를 나타내는 배열 및 부품갯수 초기화
        for (int i = 1; i < MAX; i++) {
            p[i] = i;
            cnt[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int c = Integer.parseInt(st.nextToken());
                answer.append(cnt[find(c)]).append("\n");
            }
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[b] = a;
            cnt[a] += cnt[b];
        }
    }

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }
}
