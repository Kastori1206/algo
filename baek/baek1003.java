package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *피보나치 함수
 *https://www.acmicpc.net/problem/1003 
 */
public class baek1003 {
    static int[][] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        result = new int[40 + 1][2];
        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            result[i][0] = result[i - 1][0] + result[i - 2][0];
            result[i][1] = result[i - 1][1] + result[i - 2][1];
        }
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(result[n][0] + " " + result[n][1]);
        }
        
        System.out.println(0%2);
    }
}
