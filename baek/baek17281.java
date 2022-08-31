package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 야구
 * https://www.acmicpc.net/problem/17281
 */
public class baek17281 {
    static int N, answer;
    static int[][] map;
    static int[] players;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][10];
        players = new int[10];
        selected = new boolean[10];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        players[4] = 1;
        selected[4] = true;
        permu(2);

        System.out.println(answer);
    }

    static void permu(int depth) {
        if (depth == 10) {
            answer = Math.max(answer, getScore());
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            players[i] = depth;
            permu(depth + 1);
            selected[i] = false;
        }
    }

    private static int getScore() {
        int start = 1;
        int score = 0;

        for (int i = 0; i < N; i++) {
            int[] baseball = new int[5];

            while (baseball[0] < 3) {
                play(baseball, map[i][players[start]]);
                if (start == 9) {
                    start = 1;
                } else {
                    start++;
                }
            }
            score += baseball[4];
        }
        return score;
    }

    private static void play(int[] baseball, int n) {
        for (int i = 0; i < n; i++) {
            baseball[4] += baseball[3];
            baseball[3] = baseball[2];
            baseball[2] = baseball[1];
            baseball[1] = 0;
        }
        baseball[n]++;
    }
}