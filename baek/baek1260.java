package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek1260 {
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {		
		Scanner sc  = new Scanner(System.in);
		int v = sc.nextInt();//정점수
		int e = sc.nextInt();//간선수
		int start = sc.nextInt();//시작점
		
		int[] a = new int[2];
		map = new int[v+1][v+1];
		visited = new boolean[v+1];
		
		for(int i =0;i<e;i++) {
			for(int j =0;j<2;j++) {
				a[j] =sc.nextInt();
			}
			map[a[1]][a[0]]=1;
			map[a[0]][a[1]]=1;
		}
		dfs(start);
		visited = new boolean[v+1];
		System.out.println();
		bfs(start);
	}
	static boolean isChk() {
		for(int i =1;i<visited.length;i++) {
			if(visited[i] == false) {
				return false;
			}
		}
		return true;
	}
	static void dfs(int vertex) {
		System.out.print(vertex+ " ");
		
		visited[vertex] =true;
		for(int i =1;i<map.length;i++) {
			if(map[vertex][i]==0) {
				continue;
			}
			if(visited[i]) {
				continue;
			}
			dfs(i);			
		}
	}
	static void bfs(int vertex) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(vertex);
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v +" ");
			visited[v] = true;
			for(int i =1;i<map.length;i++) {
				if(map[v][i]==0) {
					continue;
				}
				if(visited[i]) {
					continue;
				}
				q.offer(i);
				visited[i] = true;
			}
		}
	}

}
