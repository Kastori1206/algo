package codeforces.div3.round702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * D. Permutation Transformation
 * https://codeforces.com/contest/1490/problem/D
 */
public class D {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] a = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			int index = 0;
			int max = 0;
			for(int i =0;i<N;i++) {
				a[i] = Integer.parseInt(st.nextToken());
				if(max < a[i]) {
					max = a[i];
					index = i;
				}
			}
			
			int[] answer = new int[N];
			answer[index] = 0;
			dfs(0,index-1, answer,0,a, N);
			dfs(index+1,N-1, answer,0,a,N);
			
			for(Integer depth : answer) {
				System.out.print(depth +" ");
			}
			System.out.println();
		}
	}

	private static void dfs(int left, int right, int[] answer, int depth, int[] a,int N) {
		if(left>right) {
			return;
		}
		int index = 0;
		int max = 0;
		for(int i =left;i<=right;i++) {
			if(max < a[i]) {
				max = a[i];
				index = i;
			}
		}
		answer[index] = depth+1;
		
		dfs(left,index-1, answer,depth+1,a,N);
		dfs(index+1,right, answer,depth+1,a,N);
	}
}
