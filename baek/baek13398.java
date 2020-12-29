package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연속합 2
 * https://www.acmicpc.net/problem/13398
 * DP
 */
public class baek13398 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[][] d = new int[2][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[0][0] = d[1][0] = arr[0];
		int ans = d[0][0];
		
		if(N!=1){
            d[0][1] = d[1][1] = Math.max(d[0][0]+arr[1], arr[1]);
            ans = Math.max(d[0][0], d[0][1]);
        }		
		
		for(int i =2;i<N;i++) {
			d[0][i] = Math.max(d[0][i-1]+arr[i], arr[i]);
			d[1][i] = Math.max(d[0][i-2]+arr[i], d[1][i-1]+arr[i]);
			
			ans = Math.max(d[1][i],Math.max(ans, d[0][i]));				
		}

		System.out.println(ans);
		
	}
}
