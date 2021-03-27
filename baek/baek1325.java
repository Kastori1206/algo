package baek;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 효율적인 해킹
 * https://www.acmicpc.net/problem/1325
 */
public class baek1325 {
	static int N,M,count;
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] answers;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		answers = new int[N+1];
		
		for(int i =1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			
		}
		int max = 0;
		for(int i = 1;i<=N;i++) {
			visited = new boolean[N+1];		
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			visited[i] = true;
			
			while(!q.isEmpty()) {
				int v = q.poll();
				for(int next : adj[v]) {
					if(!visited[next]) {
						visited[next] = true;
						answers[next]++;
						q.add(next);
					}
				}
			}			
		}
		
		for(int i =1;i<=N;i++) {
			max = Math.max(max, answers[i]);
		}
		
		for(int i =1;i<=N;i++) {
			if(max == answers[i]) {
				answer.append(i+" ");
			}
		}
		System.out.println(answer.toString());
		
	}
}
