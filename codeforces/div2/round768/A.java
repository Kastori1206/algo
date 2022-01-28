package codeforces.div2.round768;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A. Min Max Swap
 * https://codeforces.com/contest/1631/problem/A
 */
public class A {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            int min = 0;

            for (int i = 0; i < N; i++) {
                int mmax = Math.max(arr1[i], arr2[i]);
                int mmin = Math.min(arr1[i], arr2[i]);
                if (max <= mmax) {
                    max =mmax;
                    if (mmin > min) {
                        min = mmin;
                    }
                } else {
                    if (mmin > min) {
                        min = mmin;
                    }
                }
            }
            answer.append(max * min).append("\n");
        }
        System.out.println(answer);

    }
}
