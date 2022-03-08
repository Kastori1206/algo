package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뉴스 전하기
 * https://www.acmicpc.net/problem/1135
 */
public class baek1135 {
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) {
                continue;
            }
            adj[p].add(i);
        }

        System.out.println(dfs(0));
    }

    static int dfs(int cur) {
        List<Integer> list = new ArrayList<>();

        int ret = 0;
        for (Integer child : adj[cur]) {
            list.add(dfs(child));
        }

        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            ret = Math.max(ret, list.get(i) + i + 1);
        }

        return ret;
    }
}
