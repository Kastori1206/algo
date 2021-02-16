package codeforces.div3.round702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B. Balanced Remainders
 * https://codeforces.com/contest/1490/problem/B
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int[] c = new int[3];
			int answer= 0;
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				int temp = arr[i]%3;
				if(temp ==0) {
					c[0]++;
				}else if(temp==1) {
					c[1]++;
				}else {
					c[2]++;
				}
			}
			int size = N/3;
			for(int i =0;i<3;i++) {
				if(c[i]>size) {
					answer += c[i]-size;
					c[(i+1)%3] += c[i] -size;
					c[i] = size;
				}
			}
			if(c[0] >size) {
				answer += c[0] -size;
				c[1] += c[0] -size;
				c[0] = size;
			}
			
			System.out.println(answer);
		}
	}
}
