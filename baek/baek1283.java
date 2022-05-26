package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 단축키 지정
 * https://www.acmicpc.net/problem/1283
 */
public class baek1283 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            boolean flag = false;
            char c = ' ';
            if (str.length > 1) {
                for (int j = 0; j < str.length; j++) {
                    c = str[j].charAt(0);
                    if (set.contains(c)) {
                        continue;
                    }
                    set.add(Character.toLowerCase(c));
                    set.add(Character.toUpperCase(c));
                    flag = true;
                    break;
                }
                if (!flag) {
                    for (int j = 0; j < str[0].length(); j++) {
                        c = str[0].charAt(j);
                        if (set.contains(c)) {
                            continue;
                        }
                        set.add(Character.toLowerCase(c));
                        set.add(Character.toUpperCase(c));
                        flag = true;
                        break;
                    }
                }
            }else{
                for (int j = 0; j < str[0].length(); j++) {
                    c = str[0].charAt(j);
                    if (set.contains(c)) {
                        continue;
                    }
                    set.add(Character.toLowerCase(c));
                    set.add(Character.toUpperCase(c));
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < str.length; j++) {
                    for (int k = 0; k < str[j].length(); k++) {
                        char temp = str[j].charAt(k);
                        if (temp == c) {
                            sb.append("[").append(temp).append("]");
                        } else {
                            sb.append(temp);
                        }
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            } else {
                for (int j = 0; j < str.length; j++) {
                    sb.append(str[i]).append(" ");
                }
                sb.append(" ");
            }

        }
        System.out.println(sb);
    }
}
