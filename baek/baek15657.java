package baek;

import java.util.Arrays;
import java.util.Scanner;

/*
 * N과 M(8)
 * https://www.acmicpc.net/problem/15657
 */
public class baek15657 {	
	static int[] a;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n];		
		result = new int[m];
		for(int i =0;i<n;i++) {
			a[i] = sc.nextInt();			
		}
		Arrays.sort(a);
		dfs(0,0,n,m);		
	}
	static void dfs(int start, int index, int n,int m) {
		if(index == m) {
			for(int i =0;i<m;i++) {
				System.out.print(result[i]);
				if(i!=m-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}
		for(int i =start;i<n;i++) {		
			result[index] = a[i];		
			dfs(i,index+1,n,m);	
		}
		
	}
}
