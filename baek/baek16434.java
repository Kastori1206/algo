package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 드래곤 앤 던전
 * https://www.acmicpc.net/problem/16434
 */
public class baek16434 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long curHp = 0;
        long maxHp = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (t == 1) {
                curHp += a * ((h / atk) - (h % atk != 0 ? 0 : 1));
                maxHp = Math.max(maxHp, curHp);
            } else {
                atk += a;
                curHp = Math.max(curHp - h, 0);
            }
        }

        System.out.println(++maxHp);
    }
}
