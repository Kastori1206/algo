package programmers;

import java.util.*;

/**
 * 매출 하락 최소화
 * https://programmers.co.kr/learn/courses/30/lessons/72416
 */
public class 매출하락최소화 {
    public static void main(String[] args) {
        int[] sales ={14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int[][] links = {{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}};
        System.out.println(solution(sales, links));
    }


    static List<Integer>[] adj;
    static int[][] dp = new int[300001][2];

    public static int solution(int[] sales, int[][] links) {
        adj = new ArrayList[sales.length+1];
        for (int i = 1; i <= sales.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] link : links) {
            adj[link[0]].add(link[1]);
        }

        dfs(1, sales);

        return Math.min(dp[1][0], dp[1][1]);
    }

    public static void dfs(int cur, int[] sales) {
        dp[cur][0] = 0;
        dp[cur][1] = sales[cur-1];

        if(adj[cur].isEmpty()){
            return;
        }
        int min = Integer.MAX_VALUE;
        for (Integer next : adj[cur]) {
            dfs(next, sales);
            if (dp[next][0] < dp[next][1]) {
                dp[cur][0] += dp[next][0];
                dp[cur][1] += dp[next][0];
                min = Math.min(min, dp[next][1] - dp[next][0]);
            } else {
                dp[cur][0] += dp[next][1];
                dp[cur][1] += dp[next][1];
                min = 0;
            }
        }
        dp[cur][0] +=min;
    }

}
