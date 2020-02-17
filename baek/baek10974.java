package baek;

import java.util.Scanner;

public class baek10974 {
	static int[] a;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		a = new int[n+1];
		v = new boolean[n+1];
		
		dfs(0,n);
	}
	static void dfs(int index, int n) {
		if(index == n) {
			for(int i =0;i<n;i++) {
				System.out.print(a[i]);
				if(i!=n-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}
		for(int i =1;i<=n;i++) {
			if(v[i]) continue;
			
			a[index] = i;
			v[i] = true;
			dfs(index+1,n);
			v[i] = false;
		}
	}
}
