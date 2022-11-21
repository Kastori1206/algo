package groom.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[n][1]++;
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return -Integer.compare(o1[0], o2[0]);
            }
            return -Integer.compare(o1[1], o2[1]);
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0][0]);
        for (int i = 1; i <= N; i++) {
            if (arr[0][1] != arr[i][1]) {
                break;
            }
            sb.append(" ").append(arr[i][0]);
        }
        System.out.println(sb);
    }
}

