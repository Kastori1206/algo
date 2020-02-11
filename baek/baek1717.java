package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1717 {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];//0~ n
		makeSet();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());			
			if(c ==0) {
				union(x,y);
			}else {
				if(parent[x] ==parent[y]) {
					System.out.println("YES");
				}else {
					System.out.println("NO");					
				}
			}
		}
	}
	static void makeSet() {
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if(parent[x] == x) {
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
