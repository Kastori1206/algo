package baek;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
 * 1197. 최소신장트리
 */
public class baek1197 {	
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		parents = new int[V+1];
		int[][] edges = new int[E][3];
		
		for(int i=0;i<E;i++) {
			edges[i][0] = sc.nextInt();	//시작점
			edges[i][1] = sc.nextInt(); //끝점
			edges[i][2] = sc.nextInt();	//가중치
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		//정점이 1부터 시작
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		int result = 0;
		int cnt=0;	
		
		for (int i = 0; i < E; i++) {
			int a = findSet((int)edges[i][0]);
			int b = findSet((int)edges[i][1]);
			if(a==b) {
				continue;
			}
			unionSet(a,b);
			result += edges[i][2];
			cnt++;
			
			if(cnt == V-1) {
				break;
			}
		}
		System.out.println(result);		
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			parents[py] = parents[px];
		}
	}
}
