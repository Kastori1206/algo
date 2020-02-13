package jungol;

import java.util.Scanner;
public class jungol1863 {
	static int N;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		boolean[] v= new boolean[n+1];
		N = n;
		makeSet();
		for(int i =0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			union(x,y);
		}

		System.out.println(N);
	}
	static void makeSet() {
		for(int i=1;i<parent.length;i++) {
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
		if(x==y) {
			return;
		}
		parent[y] = x;
		--N;
	}
}