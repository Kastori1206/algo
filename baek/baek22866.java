package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑 보기
 * https://www.acmicpc.net/problem/22866
 */
public class baek22866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int[][] near = new int[N + 1][2];
        int[] cnt = new int[N + 1];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i <= N; i++) {
            near[i][0] = near[i][1] = 987654321;
        }

        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] <= h[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if (!stack.isEmpty()) {
                int[] cur = stack.peek();
                int d = Math.abs(cur[0] - i);
                if (d < near[i][1]) {
                    near[i][0] = cur[0];
                    near[i][1] = d;
                } else if (d == near[i][1] && cur[0] < near[i][0]) {
                    near[i][0] = cur[0];
                }
            }
            stack.push(new int[]{i, h[i]});
        }

        stack.clear();

        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= h[i]) {
                stack.pop();
            }
            cnt[i] += stack.size();
            if (!stack.isEmpty()) {
                int[] cur = stack.peek();
                int d = Math.abs(cur[0] - i);
                if (d < near[i][1]) {
                    near[i][0] = cur[0];
                    near[i][1] = d;
                } else if (d == near[i][1] && cur[0] < near[i][0]) {
                    near[i][0] = cur[0];
                }
            }
            stack.push(new int[]{i, h[i]});
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] > 0) {
                answer.append(cnt[i]).append(" ").append(near[i][0]).append("\n");
            } else {
                answer.append(0).append("\n");
            }
        }

        System.out.println(answer);
    }
}
