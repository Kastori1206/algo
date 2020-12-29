package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연속합
 * https://www.acmicpc.net/problem/1912
 * DP
 */
public class baek1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] d = new int[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[0] = arr[0];
		int ans = d[0];
		for(int i =1;i<N;i++) {
			//이전 까지 연속된합 + 현재값 과 현재값을 비교
			d[i] = Math.max(d[i-1]+ arr[i],arr[i]);
			ans = Math.max(ans, d[i]);
		}
		
		System.out.println(ans);
	}
}
