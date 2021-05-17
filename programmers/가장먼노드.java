package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 가장 먼 노드
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */
public class 가장먼노드 {
	public static void main(String[] args) {
		int n  = 6;
		int[][] edge = new int[][] {
			{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		System.out.println(solution(n, edge));
	}
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer> adj [] = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        for(int i =0;i<=n;i++) {
        	adj[i] = new ArrayList<>();
        }
        for(int i =0;i<edge.length;i++) {
        	int a = edge[i][0];
        	int b = edge[i][1];
        	
        	adj[a].add(b);
        	adj[b].add(a);        	
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        visited[1] = true;
        dist[1] = 0;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
        	int v = q.poll();        	
        	
        	for(int next : adj[v]) {
        		if(visited[next]) {
        			continue;
        		}
        		visited[next] = true;
        		q.add(next);
        		dist[next] = dist[v]+1;
        		max = Math.max(dist[next], max);
        	}
        }
        
        for(int i =1;i<=n;i++) {
        	if(max==dist[i]) {
        		answer++;
        	}
        }
        return answer;
    }
}
