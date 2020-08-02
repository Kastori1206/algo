package swea.d4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 1251. [S/W 문제해결 응용] 4일차 - 하나로 D4 kruskal
 */
public class swea1251_kruskal {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ;t<=T;t++) {
			int N = sc.nextInt(); // 정점의수
			long[][] islands = new long[N][2];
			parents = new int[N];
			rank = new int[N];
			for(int i =0;i<N;i++) {
				islands[i][0] = sc.nextLong();
			}
			for(int i =0;i<N;i++) {
				islands[i][1] = sc.nextLong();
			}
			double E = sc.nextDouble();
		
			long[][] edges = new long[N*(N-1)/2][3];
			int k =0;
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					edges[k][0] = i;
					edges[k][1] = j;
					edges[k][2] = (long)(Math.pow(islands[i][0]-islands[j][0],2) + Math.pow(islands[i][1]- islands[j][1],2));
					
					k++;
				}
			}
			Arrays.sort(edges, new Comparator<long[]>() {
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o1[2], o2[2]);
				}
			});
			long result =0; 
			int cnt = 0;
			for(int i = 0 ;i<N;i++) {
				makeSet(i);
			}
			
			for (int i = 0; i < N*(N-1)/2; i++) {
				int a = findSet((int) edges[i][0]);
				int b = findSet((int) edges[i][1]);
				if(a==b) {
					continue;
				}
				union(a,b);
				result += edges[i][2];

				cnt++;
				if(cnt == N-1) {
					break;
				}
			}
			System.out.println("#" + t + " " + Math.round(result*E));
		}
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
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
