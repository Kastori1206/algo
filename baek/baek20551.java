package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Sort 마스터 배지훈의 후계자
 * https://www.acmicpc.net/problem/20551
 */
public class baek20551 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int D = Integer.parseInt(br.readLine());
            int idx = lowerBound(D);

            sb.append(D == arr[idx] ? idx : -1).append("\n");
        }

        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (arr[m] < target) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
