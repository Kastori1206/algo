package baek;

import java.util.Arrays;
import java.util.Scanner;

// N과 M(5)
//https://www.acmicpc.net/problem/15654

public class baek15654 {
	static int []result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		boolean[] v =new boolean[n];
		result = new int[m];
		Arrays.sort(a);
		dfs(a,v,0,n,m);
		
	}
	static void dfs(int []a ,boolean[] v, int index, int n, int m) {
		
		if(index == m) {		
			for(int i =0;i<m;i++) {
				for(int j=0;j<m;j++) {
					if(j==i) {
						continue;
					}
					if(result[i] == result[j]) {
						return;
					}
				}					
			}
			for(int i =0;i<m;i++) {
				System.out.print(result[i]);
				if(i!=m-1) {
					System.out.print(" ");
				}			
			}
			System.out.println();
			return;			
		}
		for(int i =0;i<n;i++) {
			if(v[i]) {
				continue;
			}			
			result[index] = a[i];		
			v[i] = true;
			dfs(a,v,index+1,n,m);
			v[i]= false;
		}
	}
}
