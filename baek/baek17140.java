package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 이차원 배열과 연산
 * https://www.acmicpc.net/problem/17140
 */
public class baek17140 {
    static int R, C;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        map = new int[100][100];
        R = 3;
        C = 3;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < R; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;

        for (int i = 0; i <= 100; i++) {
            if (map[r][c] == k) {
                answer = i;
                break;
            }
            if (R >= C) {
                row();
            } else {
                col();
            }
        }
        System.out.println(answer);

    }

    private static void row() {
        for (int r = 0; r < R; r++) {
            int[] arr = map[r];
            int[] cnt = new int[101];

            int max = getMax(cnt, arr);

            C = Math.max(C, max * 2);
            List<Integer> list = sort(cnt, max);

            for (int c = 0; c < list.size(); c++) {
                map[r][c] = list.get(c);
            }
            for (int c = list.size(); c < map.length; c++) {
                map[r][c] = 0;
            }
        }
    }

    private static void col() {
        for (int c = 0; c < C; c++) {
            int[] arr = new int[101];
            int[] cnt = new int[101];
            for (int r = 0; r < map.length; r++) {
                arr[r] = map[r][c];
            }
            int max = getMax(cnt, arr);
            R = Math.max(R, max * 2);

            List<Integer> list = sort(cnt, max);

            for (int r = 0; r < list.size(); r++) {
                map[r][c] = list.get(r);
            }
            for (int r = list.size(); r < map.length; r++) {
                map[r][c] = 0;
            }
        }
    }

    private static int getMax(int[] cnt, int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
            if (cnt[arr[i]] == 1 && arr[i] != 0) {
                res++;
            }
        }
        return res;
    }


    private static List<Integer> sort(int[] cnt, int max) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (res.size() == max * 2) {
                break;
            }
            for (int j = 1; j <= 100; j++) {
                if (cnt[j] == i) {
                    res.add(j);
                    res.add(i);
                }
            }
        }
        return res;
    }
}
