package groom.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String password = br.readLine();
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            String key = st.nextToken();
            StringBuilder k = new StringBuilder(key);

            if (password.length() != key.length()) {
                for (int i = 0; i < (password.length() / key.length()) - 1; i++) {
                    k.append(key);
                }
                for (int i = 0; i < password.length() % key.length(); i++) {
                    k.append(key.charAt(i));
                }
            }

            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isAlphabetic(ch)) {
                    if (cmd.equals("E")) {
                        answer.append(encode(ch, k.charAt(i)));
                    } else {
                        answer.append(decode(ch, k.charAt(i)));
                    }
                } else {
                    answer.append(ch);
                }
            }

            answer.append("\n");
        }

        System.out.println(answer);

    }

    static private char encode(char p, char k) {
        int kk = k % 26;

        if (Character.isUpperCase(p)) {
            int pp = (p - 65 + kk) % 26;
            return (char) ('A' + pp);
        } else {
            int pp = (p - 97 + kk) % 26;
            return (char) ('a' + pp);
        }
    }

    static char decode(char p, char k) {
        int kk = k % 26;

        if (Character.isUpperCase(p)) {
            int pp = (p - 65 - kk) % 26;
            if (pp < 0) {
                pp += 26;
            }
            return (char) ('A' + pp);
        } else {
            int pp = (p - 97 - kk) % 26;
            if (pp < 0) {
                pp += 26;
            }
            return (char) ('a' + pp);
        }
    }
}

/**
 * 2
 * HELLO GOORM!
 * E KEY
 * EVWIF DFZOD!
 * D KEY
 */