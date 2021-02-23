package codeforces.div2.round704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * B - Card Deck
 * https://codeforces.com/contest/1492/problem/B
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] indexs = new int[N+1];
			boolean[] visited = new boolean[N+1];
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++) {
				int num = Integer.parseInt(st.nextToken());
				indexs[num] = i; 
				arr[i] = num;
			}
			
			int start = indexs[N];
			int end = N;			
			int max = arr[start];
			
			while(start<end) {
				for(int i = start;i<end;i++) {
					answer.append(arr[i]).append(" ");
					visited[arr[i]] = true;
				}
				
				for(int i=max;i>=0;i--) {
					if(!visited[i]) {
						max = i;
						break;
					}					
				}
				end = start;
				start = indexs[max];				
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
		
	}
}
