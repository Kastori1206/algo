package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상근이의 여행
 * https://www.acmicpc.net/problem/9372
 */
public class baek9372 {
	static int N,M,answer;
	static boolean[] visited;
	static List<Integer> adj[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			answer = 0;
			adj = new ArrayList[N+1];
			for(int i =0;i<=N;i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a].add(b);
				adj[b].add(a);				
			}			
			bfs();
			//방문한 지역이 N개이면 비행기수는 N-1
			System.out.println(answer-1);
		}
		
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int country = q.poll();
			answer++;
			for(int i =0;i<adj[country].size();i++) {
				int next = adj[country].get(i);
				if(visited[next]) {
					continue;
				}
				visited[next] = true;
				q.add(next);
			}
		}
	}
}
