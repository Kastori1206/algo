package programmers;

import java.util.*;

public class 모두0으로만들기{
    public static void main(String[] args) {
        int[] a= new int[]{-5,0,2,1,2};
        int[][] edges = new int[][]{
                {0,1},
                {3,4},
                {2,3},
                {0,3},
        };
        System.out.println(solution(a,edges));
    }
    public static long solution(int[] a, int[][] edges) {
        long answer =0;
        int n = a.length;
        List<Integer> [] adj = new ArrayList[n];

        for(int i =0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[a.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        long w = a[0];
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.println("v : " + v);
            System.out.println(Arrays.toString(a));
            int ww = 0;
            for(int next : adj[v]){
                if(visited[next]){
                    continue;
                }
                if(a[next] == 0){
                    continue;
                }

                q.offer(next);
                ww += a[next];
//                answer += Math.abs(a[next]);

                a[next] = 0;
                visited[next] = true;
            }
            answer += Math.abs(ww);
            w+=ww;
            System.out.println(w + " " +ww);

        }
        return answer;
    }
}
