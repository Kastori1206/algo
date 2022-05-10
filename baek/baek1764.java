package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 듣보잡
 * https://www.acmicpc.net/problem/1764
 */
public class baek1764 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                answer.add(name);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (String name : answer) {
            System.out.println(name);
        }
    }
}
