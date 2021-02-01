package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 텀 프로젝트
 * https://www.acmicpc.net/problem/9466
 */
public class baek9466 {
	static boolean[] visited, finished;
	static List<Integer>[] adj;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			adj = new ArrayList[100001];
			arr = new int[100001];
			answer = 0;
			visited = new boolean[100001];
			finished = new boolean[100001];
			for(int i =1;i<=n;i++) {
				adj[i]  = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i =1;i<=n;i++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i =1;i<=n;i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}			
			sb.append(n-answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int u) {
		visited[u] = true;
		for(Integer v : adj[u]) {
			if(!visited[v]) {
				arr[u] = v;
				dfs(v);
			}else if(!finished[v]) {
				for(int i=v;i !=u;i = arr[i]) {
					answer++;
				}
				answer++;
			}
		}
		finished[u] = true;
	}

	
}
