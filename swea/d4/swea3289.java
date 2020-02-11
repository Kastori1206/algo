package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3289 {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1 ;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n + 1];
			makeSet();
			StringBuffer sb = new StringBuffer();
			sb.append("#"+t+" ");
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
 
				if(command ==0) {
					union(x, y);
				}else {
					if(findSet(x)==findSet(y)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			System.out.println(sb.toString());
			
		}
	}
	static void makeSet() {
		for(int i=1 ; i<parent.length; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if(parent[x] ==x) {
			return x;
		}
		
		return parent[x] = findSet(parent[x]);
	}
	static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x == y) {
			return;
		}
		parent[y] = x;
	}
}
