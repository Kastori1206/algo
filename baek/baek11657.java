package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 타임머신
 * https://www.acmicpc.net/problem/11657
 */
public class baek11657 {
    static class Edge{
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] adj = new ArrayList[N+1];

        for(int i =1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Edge(B,C));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist,INF);

        dist[1] = 0;
        boolean flag = false;

        for(int i = 1; i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < adj[j].size(); k++) {
                    Edge next = adj[j].get(k);

                    if(dist[j] != INF && dist[next.v] > dist[j] + next.w){
                        dist[next.v] = dist[j] + next.w;
                        if(i==N){
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        if(flag){
            answer.append(-1).append("\n");
        }else{
            for(int i = 2 ;i <=N;i++){
                if(dist[i] == INF){
                    answer.append(-1).append("\n");
                }else{
                    answer.append(String.valueOf(dist[i])).append("\n");
                }
            }
        }

        System.out.println(answer.toString());
    }
}
