package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 학교 탐방하기
 * https://www.acmicpc.net/problem/13418
 */
public class baek13418 {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int N, M;
    static List<Node>[] adj;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, w));
            adj[b].add(new Node(a, w));
        }

        int[] answer = new int[2];
        //최악
        pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        answer[0] = find();

        //최선
        pq = new PriorityQueue<>((o1, o2) -> o2.w - o1.w);
        answer[1] = find();

        System.out.println(answer[0] * answer[0] - answer[1] * answer[1]);

    }
    static int find() {
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Node(0, -1));

        int res = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;

            if (cur.w == 0) {
                res++;
            }
            for (Node next : adj[cur.v]) {
                pq.offer(next);
            }
        }
        return res;
    }

}
