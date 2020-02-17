package baek;

import java.util.Arrays;
import java.util.Scanner;

/*
 * N과 M(7)
 * https://www.acmicpc.net/problem/15656
 */
public class baek15656 {
	static int[] result;
	static int[] a;
	
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
		System.out.print(dfs(0,n,m));
	}
	static StringBuilder dfs(int index, int n, int m) {
	   if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(result[i]);
                if (i != m-1) sb.append(" ");
            }
            sb.append("\n");
            return sb;
        }
        StringBuilder ans = new StringBuilder();
		
		for(int i =0;i<n;i++) {
			result[index] = a[i];			
			ans.append(dfs(index+1,n,m));			
		}
		return ans;
	}
}
