package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=TC;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int i =0;i<N;i++) {
				String temp = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}			
			int start = N/2;
			int end = 1;
			int sum = 0;
			boolean flag = false;
			for(int i =0;i<N;i++){
				for(int j = start;j<start+end;j++) {					
					sum += map[i][j];
				}
				if(end==N) {
					flag = true;
				}
				if(flag) {
					end-=2;
					start += 1;
				}else {
					end+=2;
					start -= 1;
				}
			}
			
			System.out.println(String.format("#%d %d", t,sum));
		}
		
	}
}

