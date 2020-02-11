package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea7465 {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int cnt=0;
			int[] v = new int[n+1];
			parent = new int[n+1];
			makeSet();
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x,y);
			}
			for(int i=1;i<=n;i++) {
				int f = findSet(i);
				if(v[f]==0) {
					v[f] =1;
					cnt++;
				}
			}
			
			System.out.println(String.format("#%d %d", t,cnt));
		}
	}
	static void makeSet() {
		for(int i =1;i<parent.length;i++) {
			parent[i] = i;
		}
		
	}
	static int findSet(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = findSet(parent[x]);
	}
	
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x==y) {
			return;
		}
		parent[y] = x;
	}
}






