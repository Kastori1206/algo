package codeforecs.div2.round694;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] k = new int[n];
			int[] c = new int[m+1];
			int[] want = new int[m+1];
			
			boolean[] visited = new boolean[m+1];
			st= new StringTokenizer(br.readLine());
			
			for(int i =0;i<n;i++) {
				k[i] = Integer.parseInt(st.nextToken());
				want[k[i]] ++;
			}
			st= new StringTokenizer(br.readLine());
			
			for(int i =1;i<=m;i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			
			long ans =0;
			int cnt =0;
			for(int i =m;i>=0;i--) {
				if(cnt!=m) {
					while(want[i]>0) {
						boolean flag = false;
						for(int j =1;j<=m;j++) {
							if(visited[j]) {
								continue;
							}
							
							if(c[i] > c[j]) {
								ans+=c[j];
								visited[j] = true;
								cnt++;
								want[i]--;
								flag = true;
								break;
							}else {
								break;
							}
						}
						if(!flag) {
							ans+=c[i];
							want[i]--;
						}
					}					
				}else {
					while(want[i]>0) {
						ans+= c[i];
						want[i] --;
					}					
				}
				
			}
			System.out.println(ans);
		}
	}
}
