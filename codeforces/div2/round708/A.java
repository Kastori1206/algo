package codeforces.div2.round708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A. Meximization
 * https://codeforces.com/contest/1497/problem/A
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			int N  = Integer.parseInt(br.readLine());
			int[] count = new int[101];
			int[] answer = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++) {
				int index = Integer.parseInt(st.nextToken());	
				count[index]++; 			
			}
			int i= 0;
			int index = 0;
			while(index<N) {
				i %=101;
				if(count[i] !=0) {
					count[i]--;
					answer[index++] = i;					
				}
				i++;
			}
			
			for(i =0;i<N;i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
		}
	}
}
