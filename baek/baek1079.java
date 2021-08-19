package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마피아
 * https://www.acmicpc.net/problem/1079
 */
public class baek1079 {
    static int N, mafia, answer;
    static int[] arr;
    static int[][] R;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        R = new int[N][N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                R[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        mafia = Integer.parseInt(br.readLine());
        dfs(N,0);
        System.out.println(answer);
    }

    private static void dfs(int live,int cnt) {
        if (visited[mafia]) {
            answer = Math.max(cnt, answer);
            return;
        }
        if(live ==2){
            //마지막까지 살아남았을 때
            System.out.println(cnt+1);
            System.exit(0);
        }
        //밤
        if (live % 2 == 0) {
            for(int i=0;i<N;i++){
                if (visited[i]) {
                    continue;
                }
                for(int j=0;j<N;j++){
                    arr[j] += R[i][j];
                }
                visited[i] = true;
                dfs(live - 1, cnt+1);
                visited[i] = false;
                for(int j=0;j<N;j++){
                    arr[j] -= R[i][j];
                }
            }
        }
        //낮
        else{
            int idx = -1;
            int max =0;
            for(int i=0;i<N;i++){
                if (visited[i]) {
                    continue;
                }
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
            }
            visited[idx] = true;
            dfs(live - 1,cnt);
            visited[idx] = false;
        }
    }
}
