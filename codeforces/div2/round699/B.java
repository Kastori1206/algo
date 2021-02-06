package codeforces.div2.round699;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * B. New Colony
 */
public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] mounts = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				mounts[i] = Integer.parseInt(st.nextToken());				
			}
			int answer = 1;
			int index =1;
			for(int i =0;i<k;i++) {
				index = 1;
				while(index<n) {
					if(mounts[index-1] < mounts[index]) {
						mounts[index-1]++;
						answer = index;
						break;
					}
					index++;
				}
				if(index==n) {
					break;
				}
			}
			
			if(index==n) {
				System.out.println(-1);
			}else {
				System.out.println(answer);
				
			}
		}
	}
}
