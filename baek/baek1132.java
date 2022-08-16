package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 합
 * https://www.acmicpc.net/problem/1132
 */
public class baek1132 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] nums = new long[10][2];


        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();

            int temp = str.length-1;
            nums[str[0] - 'A'][1] = 1;
            nums[str[0] - 'A'][0] += (long) Math.pow(10, temp--);
            for (int j = 1; j < str.length; j++) {
                char ch = str[j];
                nums[ch - 'A'][0] += (long) Math.pow(10, temp--);
            }
        }
        long answer = 0;

        Arrays.sort(nums, Comparator.comparingLong(o -> o[0]));
        boolean[] check = new boolean[10];

        for (int i = 0; i <= 9; i++) {
            if (nums[i][1] == 1) {
                for (int j = 1; j < 10; j++) {
                    if (!check[j]) {
                        answer += nums[i][0] * (long) j;
                        check[j] = true;
                        break;
                    }

                }
            } else {
                for (int j = 0; j < 10; j++) {
                    if (!check[j]) {
                        answer += nums[i][0] * (long) j;
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
