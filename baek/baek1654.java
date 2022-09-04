package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, arr[i]);
        }

        long answer = 0;
        long l = 1;
        r++;
        while (l < r) {
            long mid = (l + r) / 2;
            int res = 0;
            for (int i = 0; i < N; i++) {
                res += arr[i] / mid;
            }

            if (res >= K) {
                l = mid + 1;
                answer = Math.max(answer, mid);
            }else {
                r = mid;
            }
        }
        System.out.println(answer);
    }
}
