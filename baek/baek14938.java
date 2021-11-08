package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 서강그라운드
 * https://www.acmicpc.net/problem/14938
 */
public class baek14938 {
	static class Node implements Comparable<Node>{
		int v, w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}
		
	}
	
	static List<Node>[] adj;
	static int[] dist, items;
	static final int INF = 987654321;
	static int N, M, R, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList[N+1];
		for(int i = 0;i <=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b,w));
			adj[b].add(new Node(a,w));
		}
		
		for(int i =1;i<=N;i++) {
			dijkstra(i);
		}
		System.out.println(answer);
		
	}
	public static void dijkstra(int start) {
		int res = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		q.offer(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(Node next : adj[cur.v]) {
				if(dist[next.v] > cur.w + next.w) {
					dist[next.v] = cur.w + next.w;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			if(dist[i] <=M) {
				res += items[i];
			}
		}
		answer = Math.max(answer, res);
	}

}
