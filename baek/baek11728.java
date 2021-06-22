package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 배열 합치기
 * https://www.acmicpc.net/problem/11728
 */
public class baek11728 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N + M];
        int a = 0, b = 0, index = 0;

        while (a < N && b < M) {
            if (A[a] <= B[b]) {
                answer[index++] = A[a++];
            } else {
                answer[index++] = B[b++];
            }
        }
        if (index < N + M) {
            while (a < N) {
                answer[index++] = A[a++];
            }
            while (b < M) {
                answer[index++] = B[b++];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(answer[i]+" ");
        }
        System.out.println(sb.toString());
    }
}