package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 트리
 * https://www.acmicpc.net/problem/4803
 */
public class baek4803 {
    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }
            p = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                p[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);

            }
            Set<Integer> set = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                int pi = find(i);
                if (pi > 0) {
                    set.add(pi);
                }
            }
            answer.append("Case ").append(T).append(": ");
            int cnt = set.size();
            if (cnt == 0) {
                answer.append("No trees.\n");
            } else if (cnt == 1) {
                answer.append("There is one tree.\n");
            } else {
                answer.append("A forest of ").append(cnt).append(" trees.\n");
            }
            T++;
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (a == p[a]) {
            return a;
        }
        return find(p[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        //같은 트리
        if (a == b) {
            p[a] = 0;
        } else {
            p[b] = a;
        }
    }
}

