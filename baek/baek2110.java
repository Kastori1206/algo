package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공유기 설치
 * https://www.acmicpc.net/problem/2110
 */
public class baek2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 1; //최소 거리
        int r = arr[N - 1] - arr[0]; //가능한 최대 거리
        int dist = 0;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int start = arr[0];
            int res = 1;//공유기 설치 수

            //공유기 설치
            for (int i = 1; i < N; i++) {
                dist = arr[i] - start;
                if (mid <= dist) {
                    res++;
                    start = arr[i];
                }
            }

            if (res >= C) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
