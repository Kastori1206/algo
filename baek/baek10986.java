package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나머지 합
 * https://www.acmicpc.net/problem/10986
 */
public class baek10986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[1000001];
        long[] cnt = new long[1001];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            arr[i] += arr[i - 1];
            arr[i] %= M;

            cnt[(int) arr[i]]++;
        }

        long answer = cnt[0];
        for (int i = 0; i < M; i++) {
            answer += cnt[i] * (cnt[i] - 1) / 2;
        }
        System.out.println(answer);
    }
}
