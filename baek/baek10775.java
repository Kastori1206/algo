package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 공항
 * https://www.acmicpc.net/problem/10775
 */
public class baek10775 {
    static int[] p;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int answer = 0;
        p = new int[G + 1];

        for (int i = 0; i <= G; i++) {
            p[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());

            int temp = find(g);

            if (temp != 0) {
                union(temp, temp - 1);
                answer++;
            }else{
                break;
            }
        }
        System.out.println(answer);

    }

    static int find(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        p[a] = b;
    }
}
