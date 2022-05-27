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
            String answer = br.readLine();
            String[] str = answer.split(" ");
            boolean flag = false;

            if (str.length > 1) {
                for (int j = 0; j < str.length; j++) {
                    char c = Character.toUpperCase(str[j].charAt(0));
                    if (set.contains(c)) {
                        continue;
                    }
                    str[j] = "[" + str[j].charAt(0) + "]" + str[j].substring(1);
                    flag = true;
                    set.add(c);
                    break;
                }
                answer = String.join(" ", str);

                if (!flag) {
                    for (int j = 0; j < answer.length(); j++) {
                        char c = Character.toUpperCase(answer.charAt(j));
                        if (c == ' ' || set.contains(c)) {
                            continue;
                        }
                        set.add(c);
                        answer = answer.substring(0, j) + "[" + answer.charAt(j) + "]" + answer.substring(j + 1);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < str[0].length(); j++) {
                    char c = Character.toUpperCase(str[0].charAt(j));
                    if (set.contains(c)) {
                        continue;
                    }
                    set.add(c);
                    answer = str[0].substring(0, j) + "[" + str[0].charAt(j) + "]" + str[0].substring(j + 1);
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
