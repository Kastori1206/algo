package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 징검다리 건너기 (large)
 * https://www.acmicpc.net/problem/22871
 */
public class baek22871 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long l = 0;
        long r = (long) (N - 1) * (1 + Math.abs(arr[N - 1] - arr[0]));
        long answer = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            if (check(N, arr, mid)) {
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int N, int[] arr, long mid) {
        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur == N - 1) {
                return true;
            }

            for (int i = cur + 1; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                long k = (long) (i - cur) * (1 + Math.abs(arr[i] - arr[cur]));
                if (k <= mid) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
