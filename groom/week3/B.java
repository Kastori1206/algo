package groom.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 폴더 폰 자판
 */
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] input = {"",
                "1.,?!",
                "2ABC",
                "3DEF",
                "4GHI",
                "5JKL",
                "6MNO",
                "7PQRS",
                "8TUV",
                "9WXYZ"
        };

        String temp = br.readLine();

        int j = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char ch = temp.charAt(i);
            int cnt = 0;
            while (j<N) {
                if (ch != temp.charAt(j)) {
                    break;
                }
                cnt++;
                j++;
            }
            i = j -1;

            answer.append(input[ch - '0'].charAt((cnt - 1) % input[ch - '0'].length()));
        }
        System.out.println(answer);
    }
}
