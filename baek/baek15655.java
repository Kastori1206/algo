package baek;
/*
 * N과 M(6)
 * https://www.acmicpc.net/problem/15655
 */
import java.util.Arrays;
import java.util.Scanner;

public class baek15655 {
	static int[] result;
	static int[] a;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		a = new int[n];
		v = new boolean[n];
		result = new int[m];
		for(int i =0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		dfs(0,0,n,m);
	}
	static void dfs(int index, int start,int n, int m) {
		if(index ==m) {
			for(int i =0;i<m;i++) {
				System.out.print(result[i]);
				if(i!=m-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}
		for(int i = start; i<n;i++) {
			if(v[i]) {
				continue;
			}
			result[index] = a[i];
			v[i] = true;
			dfs(index+1,i+1,n,m);
			v[i] =false;
		}
	}
}
