package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 십자카드 문제
 * https://www.acmicpc.net/problem/2659
 */
public class baek2659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            input.append(st.nextToken());
        }
        int num = Integer.parseInt(input.toString());
        int target = num;
        for (int i = 0; i < 4; i++) {
            int a = num % 10;
            num /= 10;
            num += a * 1000;
            target = Math.min(target, num);
        }

        int answer = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        int temp = i * 1000 + j * 100 + k * 10 + l;
                        if (set.contains(temp)) {
                            continue;
                        }
                        if (temp == target) {
                            System.out.println(answer);
                            return;
                        }
                        for (int n = 0; n < 4; n++) {
                            int a = temp % 10;
                            temp /= 10;
                            temp += a * 1000;
                            set.add(temp);
                        }
                        answer++;
                    }
                }
            }
        }
    }
}
