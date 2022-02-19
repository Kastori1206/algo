package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 겹치는 건 싫어
 * https://www.acmicpc.net/problem/20922
 */
public class baek20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        int l = 0;
        int r = 0;

        while (r < N && l <= r) {
            if (r <= N - 1 && cnt[arr[r]] < K) {
                cnt[arr[r]]++;
                r++;
            } else if (cnt[arr[r]] == K) {
                cnt[arr[l]]--;
                l++;
            }
            answer = Math.max(answer, r - l);
        }

        System.out.println(answer);
    }
}
