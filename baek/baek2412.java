package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 암벽 등반
 * https://www.acmicpc.net/problem/2412
 */
public class baek2412 {
    static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
    static Node[] map;
    static int[] dist;
    static int N , T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new Node[N + 1];
        dist = new int[N + 1];

        map[0] = new Node(0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[i] = new Node(x, y);
        }

        Arrays.sort(map);

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 1;

        while (!q.isEmpty()) {
            int idx = q.poll();
            Node cur = map[idx];
            if (cur.y == T) {
                return dist[idx] - 1;
            }
            for (int i = idx - 1; i > 0; i--) {
                Node next = map[i];
                if (Math.abs(cur.x - next.x) > 2) {
                    break;
                }
                if (dist[i] != 0) {
                    continue;
                }
                if (Math.abs(cur.y - next.y) > 2) {
                    continue;
                }
                dist[i] = dist[idx] + 1;
                q.offer(i);
            }

            for (int i = idx + 1; i <= N; i++) {
                Node next = map[i];
                if (Math.abs(cur.x - next.x) > 2) {
                    break;
                }
                if (dist[i] != 0) {
                    continue;
                }
                if (Math.abs(cur.y - next.y) > 2) {
                    continue;
                }
                dist[i] = dist[idx] + 1;
                q.offer(i);
            }
        }

        return -1;
    }
}
