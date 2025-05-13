package baek;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11047

public class baek11074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        while(true){
            if (K == 0) {
                break;
            }
            for (int i = N - 1; i >= 0; i--) {
                if (K >= arr[i]) {
                    K -= arr[i];
                    result++;
                    break;
                }
            }
        }


        sb.append(result);
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
