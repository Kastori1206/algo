package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 창고 다각형
 * https://www.acmicpc.net/problem/2304
 */
public class baek2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int maxL = -1;
        int maxH = -1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (h > maxH) {
                maxH = h;
                maxL = l;
            }
            start = Math.min(start, l);
            end = Math.max(end, l);
            arr[l] = h;
        }

        int answer = 0;

        int res = 0;
        for (int i = start; i < maxL; i++) {
            res = Math.max(res, arr[i]);
            answer += res;
        }

        res = 0;
        for (int i = end; i >= maxL; i--) {
            res = Math.max(res, arr[i]);
            answer += res;
        }
        System.out.println(answer);
    }
}
