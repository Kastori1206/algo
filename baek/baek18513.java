package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 샘터
 * https://www.acmicpc.net/problem/18513
 */
public class baek18513 {
    static int[] dir = {1, -1};
    static long answer;
    static Set<Integer> visited;
    static Queue<int[]> q;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        visited = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            visited.add(v);
            q.offer(new int[]{v, 0});
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        while (true) {
            int[] cur = q.poll();
            int v = cur[0];
            int d = cur[1];
            for (int i = 0; i < 2; i++) {
                int nv = v + dir[i];
                int nd = d + 1;
                if (check(nv, nd) && --K == 0) {
                    return;
                }
            }
        }
    }

    static boolean check(int v, int d) {
        if (visited.contains(v)) {
            return false;
        }
        visited.add(v);
        q.offer(new int[]{v, d});
        answer += d;
        return true;
    }
}
