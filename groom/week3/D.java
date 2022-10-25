package groom.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class D {
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        while (true) {
            boolean check = true;
            for (int i = 1; i <= N; i++) {
                if (adj[i].size() == 1) {
                    Integer n = adj[i].get(0);
                    adj[i].remove(n);
                    adj[n].remove((Integer)i);
                    check = false;
                }
            }
            if (check) {
                break;
            }

        }
        for (int i = 1; i <= N; i++) {
            if (adj[i].size() == 0) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                temp.add(cur);
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    q.offer(next);
                    visited[next] = true;
                }
            }
            if (temp.size() >= answer.size()) {
                answer = new ArrayList<>();
                answer.addAll(temp);
            }
        }


        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}


/**
 * 5
 * 5 2
 * 2 4
 * 4 3
 * 3 1
 * 1 2

 * 6
 * 1 2
 * 2 3
 * 1 3
 * 4 5
 * 5 6
 * 6 4
 */