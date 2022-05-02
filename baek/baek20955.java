package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 민서의 응급 수술
 * https://www.acmicpc.net/problem/20955
 */
public class baek20955 {
    static int[] p;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!union(a, b)) {
                answer++;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        System.out.println(answer + set.size() - 1);
    }

    static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[b] = a;
            return true;
        }
        return false;
    }
}
