package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 수들의 합2
 * https://www.acmicpc.net/problem/2003
 */
public class baek2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i =0;i<N;i++) {
			long sum = 0;
			for(int j=i;j<N;j++) {
				sum +=arr[j];
				if(sum == M) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
