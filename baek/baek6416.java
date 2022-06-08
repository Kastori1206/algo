package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리인가?
 * https://www.acmicpc.net/problem/6416
 */
public class baek6416 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int k = 1;
        int E = 0;
        int u = -2, v = -2;
        Map<Integer, Integer> hm = new HashMap<>();

        while (u != -1 && v != -1) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                if (u == 0 && v == 0) {
                    int root = 0;
                    boolean flag = true;
                    for (int key : hm.keySet()) {
                        if (hm.get(key) == 0) {
                            root++;
                        } else if (hm.get(key) > 1) {
                            flag = false;
                            break;
                        }
                    }
                    sb.append("Case ").append(k++).append(" is ");
                    if (hm.size() == 0 || (flag && root == 1 && E == hm.size() - 1)) {
                        sb.append("a tree");
                    } else {
                        sb.append("not a tree");
                    }
                    sb.append(".\n");
                    E = 0;
                    hm = new HashMap<>();

                } else if (u == -1 && v == -1) {
                    System.out.println(sb);
                    return;
                } else {
                    hm.put(u, hm.getOrDefault(u, 0));
                    hm.put(v, hm.getOrDefault(v, 0) + 1);
                    E++;
                }
            }
        }
    }
}
