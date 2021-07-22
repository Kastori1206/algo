package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */
public class baek1916 {
    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static List<Node>[] adj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[x].add(new Node(y, w));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] d = new int[N+1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(A, 0));
        d[A] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.v == B){
                break;
            }
            if(visited[cur.v]){
                continue;
            }
            visited[cur.v] = true;
            for (Node next : adj[cur.v]) {
                int dist = next.w + cur.w;
                if (d[next.v] > dist) {
                    d[next.v] = dist;
                    pq.offer(new Node(next.v, dist));
                }
            }
        }
        System.out.println(d[B]);
    }
}
