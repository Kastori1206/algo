package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제집
 * https://www.acmicpc.net/problem/1766
 */
public class baek1766 {
	static List<Integer>[] adj;
	static int N, M;
	static int[] indegree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		
		for(int i = 0; i<=N; i++) {
			adj[i] = new ArrayList<>();			
		}
		
		for(int i =0 ; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i =1; i<=N;i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			bw.write(cur +" ");
			
			for(int next : adj[cur]) {
				indegree[next]--;
				if(indegree[next]==0) {
					q.offer(next);
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
