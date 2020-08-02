package baek;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek1753 {
	static class Edge implements Comparable<Edge>{
		int v ,weight;
		Edge(int v, int weight){
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {		
			return Integer.compare(this.weight, o.weight);
		}				
	}
	static final int INF = 987654321;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int start = sc.nextInt();
		
		List<Edge>[] adj = new ArrayList[V+1];
		for(int i =1;i<=V;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i<E;i++) {
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V+1];
		Edge[] D = new Edge[V+1];
		
		for(int i = 1; i <= V; i++) {
			//원하는 출발지
			if( i == start ) {
				D[i] = new Edge(i, 0);
			}
			else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while( !pq.isEmpty() ) {
			Edge edge = pq.poll();
			
			for( Edge next : adj[edge.v] ) {
				if( !check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight ) {
					if( D[edge.v].weight != Integer.MAX_VALUE) {
						D[next.v].weight = D[edge.v].weight + next.weight;
										
					}else {
						D[next.v].weight = Integer.MAX_VALUE;						
					}
					pq.remove(D[next.v]);
					pq.add(D[next.v]);	
				}
			}
			check[edge.v] = true;
		}
		StringBuffer sb = new StringBuffer();
		for(int i =1;i<=V;i++) {
			if(D[i].weight==Integer.MAX_VALUE) {
				sb.append("INF\n");				
			}else {
				sb.append(D[i].weight+"\n");
			}
		}
		System.out.print(sb.toString());
	}
}
