package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문자열 집합
 * https://www.acmicpc.net/problem/14425
 */
public class baek14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
