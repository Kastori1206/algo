package codeforces.div2.round768;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B. Fun with Even Subarrays
 * https://codeforces.com/contest/1631/problem/B
 */
public class B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            int value = arr[N - 1];
            int l = N-1;
            int cnt = 1;
            while (cnt < N) {
                if (arr[l-cnt] != value) {
                    res++;
                    cnt*=2;
                }else{
                    cnt ++;
                }
            }
            answer.append(res).append("\n");

        }
        System.out.println(answer);
    }
}
