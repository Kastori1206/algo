package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 이진 딸기
 * https://www.acmicpc.net/problem/22935
 */

public class baek22935 {
    public static void main(String[] args) throws Exception {

        StringBuilder sb;
        Map<Integer, String> map = new HashMap<Integer, String>();
        int idx = 0;
        for (int i = 1; i < 1 << 4; i++) {
            sb = new StringBuilder();
            for (int j = 3; j >= 0; j--) {
                if ((i & 1 << j) == 0) {
                    sb.append("V");
                } else {
                    sb.append("딸기");
                }
            }
            map.put(idx++, sb.toString());
        }
        for (int i = 14; i > 1; i--) {
            sb = new StringBuilder();
            for (int j = 3; j >= 0; j--) {
                if ((i & 1 << j) == 0) {
                    sb.append("V");
                } else {
                    sb.append("딸기");
                }
            }
            map.put(idx++, sb.toString());

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine())-1;
            N %=  28;
            sb.append((map.get((int)N))).append(("\n"));
        }
        System.out.println(sb);
    }
}
