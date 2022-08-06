package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 7701. 염라대왕의 이름 정렬
 */
public class swea7701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() < o2.length()) {
                        return -1;
                    } else if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else {
                        return 1;
                    }
                }
            });
            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }

            sb.append("#").append(t).append("\n");
            for (String name : set) {
                sb.append(name).append("\n");

            }
        }
        System.out.println(sb);
    }
}


