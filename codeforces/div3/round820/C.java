package codeforces.div3.round820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * C. Jumping on Tiles
 */
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();

            int n = arr.length;
            List<Integer>[] list = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }
            int s = (arr[0] - 'a');
            int e = (arr[n - 1] - 'a');

            for (int i = 0; i < n; i++) {
                list[arr[i] - 'a'].add(i + 1);
            }
            List<Integer> path = new ArrayList<>();
            if (s <= e) {
                for (int j = s; j <= e; j++) {
                    path.addAll(list[j]);
                }
            } else {
                for (int j = s; j >= e; j--) {
                    path.addAll(list[j]);
                }
            }

            sb.append(Math.abs(s - e)).append(" ").append(path.size()).append("\n");
            for (Integer p : path) {
                sb.append(p).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
