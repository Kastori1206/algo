package swea.d5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1256. [S/W 문제해결 응용] 6일차 - K번째 접미어
 */
public class swea1256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());

            String answer = "none";
            String str = br.readLine();

            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                list.add(str.substring(i));
            }

            Collections.sort(list);
            if (list.size() >= K - 1) {
                answer = list.get(K - 1);
            }

            sb.append(String.format("#%d %s\n", t, answer));
        }
        System.out.print(sb);
    }
}
