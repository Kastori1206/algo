package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리 디자이너 호석
 * https://www.acmicpc.net/problem/22253
 */
public class baek22253 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] nums;
    static final int MOD = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        visited = new boolean[N];

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i  = 0; i<N;i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        long[] answer = dfs(0);
        long ans = 0;
        for (long l : answer) {
            ans+= l%MOD;
            ans%=MOD;
        }
        System.out.println(ans);
    }

    public static long[] dfs(int cur) {
        visited[cur] = true;
        long[] answer = new long[10];

        answer[nums[cur]] +=1;
        for (Integer next : adj[cur]) {
            if (visited[next]) {
                continue;
            }
            long[] next_ans = dfs(next);
            for(int i = 0 ; i<10;i++){
                answer[i] += next_ans[i];
                if(i>= nums[cur]) {
                    answer[nums[cur]] += next_ans[i];
                }
                answer[i] %= MOD;
            }
        }

        return answer;
    }
}
