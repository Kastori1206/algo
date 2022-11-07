package groom.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    static int N;
    static int[] arr, output;
    static boolean[] visited;
    static long answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        answer = Long.MAX_VALUE;
        permu(0);
        System.out.println(answer);
    }

    static void permu(int depth) {
        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            int pre = output[0];
            sb.append(pre);
            for (int i = 1; i < N; i++) {
                if (pre % 10 == output[i] / 10) {
                    sb.append(output[i] % 10);
                } else {
                    sb.append(output[i]);
                }
                pre = output[i];
            }
            long temp = Long.parseLong(sb.toString());
            if (answer > temp) {
                answer = temp;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[depth] = arr[i];
            permu(depth + 1);
            visited[i] = false;
        }
    }
}
