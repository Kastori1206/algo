package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 소수 경로
 * https://www.acmicpc.net/problem/1963
 */
public class baek1963 {
    static int start, end;
    static boolean[] prime;
    static final int MAX = 10001;
    static int[] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        prime = new boolean[MAX];
        Arrays.fill(prime, true);

        for (int i = 2; i * i < MAX; i++) {
            for (int j = i * i; j < MAX; j += i) {
                prime[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            cnt = new int[MAX];
            Arrays.fill(cnt, -1);

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            bfs();
            if (cnt[end] == -1) {
                sb.append("Impossible");
            } else {
                sb.append(cnt[end]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        cnt[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 4; i++) {
                char[] num = String.valueOf(cur).toCharArray();
                for (int j = 0; j < 10; j++) {
                    num[i] = (char) (j + '0');
                    int next = getNext(num);

                    if (next < 1000) {
                        continue;
                    }
                    if (!prime[next]) {
                        continue;
                    }
                    if (cnt[next] != -1) {
                        continue;
                    }

                    cnt[next] = cnt[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    static int getNext(char[] num) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = res * 10 + (num[i] - '0');
        }
        return res;
    }
}
