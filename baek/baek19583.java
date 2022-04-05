package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 싸이버개강총회
 * https://www.acmicpc.net/problem/19583
 */
public class baek19583 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.length() == 0) {
                break;
            }
            st = new StringTokenizer(temp);
            String time = st.nextToken();
            String name = st.nextToken();

            if (S.compareTo(time) >= 0) {
                set.add(name);
            } else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                if (set.contains(name)) {
                    set2.add(name);
                }
            }
        }

        System.out.println(set2.size());
    }
}
