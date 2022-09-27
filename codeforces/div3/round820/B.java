package codeforces.div3.round820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B. Decode String
 */
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char ch = 'a';
        char[] a = new char[27];
        for (int i = 1; i <= 26; i++) {
            a[i] = ch++;
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] str = br.readLine().toCharArray();
            StringBuilder answer = new StringBuilder();
            int i = n - 1;
            while (i >= 0) {
                if (str[i] == '0' && str[i - 1] != 0) {
                    i -= 3;
                    String temp = str[i + 1] +""+ str[i + 2];
                    int idx = Integer.parseInt(temp);
                    answer.insert(0, a[idx]);

                } else if (str[i] == '0' && str[i - 1] == '0') {
                    i--;
                } else {
                    i -= 1;
                    int idx = str[i + 1] - '0';
                    answer.insert(0, a[idx]);
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
