package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 순열 사이클
 * https://www.acmicpc.net/problem/10451
 */
public class baek10451 {
    static boolean[] visited, finished;
    static List<Integer>[] adj;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t =0;t<T;t++){
            answer = 0;
            int N = Integer.parseInt(br.readLine());
            adj = new ArrayList[N+1];
            for(int i = 1; i<=N;i++){
                adj[i] = new ArrayList<>();
            }
            visited = new boolean[N+1];
            finished = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                adj[i].add(Integer.parseInt(st.nextToken()));
            }

            for(int i= 1; i<=N;i++){
                if(visited[i]){
                    continue;
                }
                dfs(i);
            }

            sb.append(String.valueOf(answer)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dfs(int v){
        visited[v]  = true;
        for (Integer next : adj[v]) {
            if(!visited[next]){
                dfs(next);
            } else if (!finished[next]) {
                answer++;
            }
        }
        finished[v] = true;
    }
}
