package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 호텔
 * https://www.acmicpc.net/problem/1106
 */
public class baek1106 {
    static class Node {
        int cost;
        int customer;

        public Node(int cost, int customer) {
            this.cost = cost;
            this.customer = customer;
        }
    }

    static Node[] city;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        city = new Node[30];
        dp = new int[100010];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            city[i] = new Node(cost, customer);
        }

        for (int i = 1; i < 100001; i++) {
            for (int j = 0; j < N; j++) {
                if (city[j].cost <= i)
                    dp[i] = Math.max(dp[i], dp[i - city[j].cost] + city[j].customer);
            }

            if (dp[i] >= C) {
                System.out.println(i);
                break;
            }
        }
    }
}
