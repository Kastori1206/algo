package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 추월
 * https://www.acmicpc.net/problem/2002
 */
public class baek2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}