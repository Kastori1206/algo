package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek12908 {
    static class Node {
        int x1, y1, x2, y2;

        public Node(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static Node[] map;
    static long answer;
    static int sx, sy, ex, ey;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new Node[7];
        visited = new boolean[7];
        answer = Long.MAX_VALUE;

        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            map[idx++] = new Node(x1, y1, x2, y2);
            map[idx++] = new Node(x2, y2, x1, y1);
        }
        map[idx] = new Node(ex, ey, ex, ey);

        dfs(0, new int[7]);
        System.out.println(answer);
    }

    static void dfs(int idx, int[] output) {
        if (idx == 7) {
            long res = 0;
            int x = sx;
            int y = sy;
            for (int i = 0; i < output.length; i++) {
                res = dist(x, y, map[output[i]].x1, map[output[i]].y1);
                if (map[output[i]].x2 == ex && map[output[i]].y2 == ey) {
                    break;
                }
                res += 10;
                x = map[output[i]].x2;
                y = map[output[i]].y2;

            }
            System.out.println(Arrays.toString(output));
            System.out.println(res);
            answer = Math.min(answer, res);
            return;
        }
        for (int i = 0; i < 7; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[idx] = i;
            dfs(idx + 1, output);
            visited[i] = false;
        }
    }
    static long dist(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
